package com.danverem.stores.controllers;

import com.danverem.stores.dtos.UserLogin;
import com.danverem.stores.dtos.UserToken;
import com.danverem.stores.services.AuthService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@LocalBean
public class AuthController {

    @Inject
    private AuthService authService;

    @POST
    @Path("login")
    public Response logIn(UserLogin userLogin) {
        boolean authenticated = authService.logIn(userLogin);

        if (authenticated) {
            UserToken token = authService.generateToken(userLogin);

            return Response.ok().entity(token).build();
        }

        return Response
            .status(Response.Status.UNAUTHORIZED)
            .entity(new InvalidCredentials())
            .build();
    }
}
