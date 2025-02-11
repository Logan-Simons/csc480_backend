package com.gateway;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/api")
public class RestApplication {

    private final Client client = ClientBuilder.newClient();

    // Forward quote search requests
    @GET
    @Path("/quotes/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forwardQuoteRequest(@PathParam("id") String id) {
        // Assume the Quote service runs on port 9081 or at a known URL.
        String quoteServiceUrl = "http://localhost:9081/quotes/search/" + id;
        return client.target(quoteServiceUrl)
                     .request(MediaType.APPLICATION_JSON)
                     .get();
    }

    // Forward authentication requests
    @GET
    @Path("/users/auth/token")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forwardAuthRequest() {
        // Assume the User service's auth endpoint runs on port 9082 or at a known URL.
        String authServiceUrl = "http://localhost:9082/users/auth/token";
        return client.target(authServiceUrl)
                     .request(MediaType.APPLICATION_JSON)
                     .get();
    }

    // Forward user account requests
    @GET
    @Path("/users/account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forwardAccountRequest(@PathParam("id") String id) {
        // Assume the User service's account endpoint runs on port 9082 or at a known URL.
        String accountServiceUrl = "http://localhost:9082/users/account/" + id;
        return client.target(accountServiceUrl)
                     .request(MediaType.APPLICATION_JSON)
                     .get();
    }
}