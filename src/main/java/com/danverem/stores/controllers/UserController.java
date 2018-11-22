package com.danverem.stores.controllers;

import com.danverem.stores.dtos.PaginatedResource;
import com.danverem.stores.dtos.UserDTO;
import com.danverem.stores.models.User;
import com.danverem.stores.services.UserService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@LocalBean
public class UserController {

    @Inject
    private UserService userService;

    @GET
    public Response index(@DefaultValue("50") @QueryParam("limit") Integer limit, @DefaultValue("0") @QueryParam("offset") Integer offset) {
        PaginatedResource<UserDTO> users  = userService.getAll(limit, offset);

        return Response.ok().entity(users).build();
    }

    @POST
    public Response store(User user) {
        User newUser = userService.create(user);

        return Response
            .status(Response.Status.CREATED)
            .entity(newUser)
            .build();
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long ID) {
        Optional<User> user = userService.find(ID);

        if (user.isPresent()) {
            return Response
                .ok()
                .entity(user.get())
                .build();
        }

        throw new EntityNotFoundException("User not found");
    }

    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Long ID, User user) {
         Optional<User> editedUser = userService.edit(ID, user);

         if (editedUser.isPresent()) {
             return Response.ok().entity(editedUser).build();
         }

        throw new EntityNotFoundException("User not found");
    }

    @DELETE
    @Path("{id}")
    public Response destroy(@PathParam("id") Long ID) {
        userService.delete(ID);

        return Response.ok().build();
    }
}
