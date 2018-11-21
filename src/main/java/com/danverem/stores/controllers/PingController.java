package com.danverem.stores.controllers;

import com.danverem.stores.services.PingService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
@Stateless
@LocalBean
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PingController {

    @Inject
    private PingService pingService;

    @GET
    public Response ping() {
        return Response.ok().entity(pingService.ping()).build();
    }
}
