package com.github.fabriciolfj.gateway.providers.limit.http;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Path;

@Path("limits")
@RegisterRestClient
public interface LimitClient {
}
