package com.quotes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/token")
public class AuthResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getToken() {
        return "{\"Token\": \"You found a token!.\"}";
    }
}
