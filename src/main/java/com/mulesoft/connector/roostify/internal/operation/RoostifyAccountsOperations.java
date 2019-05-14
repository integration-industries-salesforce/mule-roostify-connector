/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connector.roostify.internal.operation;

import com.mulesoft.connector.roostify.internal.config.RoostifyConfiguration;
import com.mulesoft.connector.roostify.internal.connection.RoostifyConnection;
import com.mulesoft.connector.roostify.internal.error.ErrorProvider;
import com.mulesoft.connector.roostify.api.resultObject.ResponseStatus;
import com.mulesoft.connector.roostify.internal.services.AccountsService;
import com.mulesoft.connector.roostify.internal.services.AccountsServiceImpl;
import org.mule.connectors.commons.template.operation.ConnectorOperations;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.fixed.OutputJsonType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;

public class RoostifyAccountsOperations extends ConnectorOperations<RoostifyConfiguration, RoostifyConnection, AccountsService> {

    public RoostifyAccountsOperations() {
        super(AccountsServiceImpl::new);
    }

    /**
     * @param configuration Roostify Configuration Object.
     * @param connection Roostify connection  instance.
     * @param page       Indicates the page of the index which should be returned. When this parameter is not present and count is, it defaults to 1. When both parameters are not present pagination is disabled.
     * @param count      Indicates the number of records per page returned. When this parameter is not present and page is, it defaults to 100. When both parameters are not present pagination is disabled.
     */
    @DisplayName(value = "Listing accounts")
    @OutputJsonType(schema = "metadata/listingAccounts")
    @Throws({ErrorProvider.class})
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    public Result<InputStream, ResponseStatus> listingAccounts(@Config RoostifyConfiguration configuration, @Connection RoostifyConnection connection, @Optional String page, @Optional String count) {

        return newExecutionBuilder(configuration, connection)
                .execute(AccountsService::listingAccounts).withParam(page).withParam(count);
    }

    /**
     * Retrieving an Account
     *
     * @param configuration Roostify Configuration Object.
     * @param connection Roostify connection  instance.
     * @param id         id
     */
    @OutputJsonType(schema = "metadata/retrieveAccount")
    @Throws({ErrorProvider.class})
    @DisplayName(value = "Retrieve an account")
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)

    public Result<InputStream, ResponseStatus> retrievingAccount(@Config RoostifyConfiguration configuration, @Connection RoostifyConnection connection, String id) {
        return newExecutionBuilder(configuration, connection)
                .execute(AccountsService::retrievingAccount).withParam(id);

    }
}