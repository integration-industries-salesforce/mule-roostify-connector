/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connector.roostify.internal.services;

import com.mulesoft.connector.roostify.api.resultObject.ResponseStatus;
import org.mule.connectors.commons.template.service.ConnectorService;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;

public interface WebhookEventsService extends ConnectorService{

	Result<InputStream, ResponseStatus> listingWebhookEvents(String page, String count, String created);
}

