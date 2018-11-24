package com.danverem.stores.controllers;

import com.danverem.stores.dtos.ItemDTO;
import com.danverem.stores.dtos.PaginatedResource;
import com.danverem.stores.services.ItemService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@LocalBean
public class ItemController {

    @Inject
    private ItemService itemService;

    @GET
    public Response index(
        @DefaultValue("50") @QueryParam("limit") int limit,
        @DefaultValue("0") @QueryParam("offset") int offset
    ) {
        PaginatedResource<ItemDTO> items = itemService.getAll(limit, offset);

        return Response.ok().entity(items).build();
    }

    @POST
    public Response store(ItemDTO itemDTO) {
        ItemDTO item = itemService.create(itemDTO);

        return Response.status(Response.Status.CREATED).entity(item).build();
    }


    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long ID) {
        Optional<ItemDTO> item = itemService.find(ID);

        if (item.isPresent()) {
            return Response.ok().entity(item.get()).build();
        }

        throw new EntityNotFoundException("Item not found");
    }


    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Long ID, ItemDTO itemDTO) {
        Optional<ItemDTO> item = itemService.edit(ID, itemDTO);

        if (item.isPresent()) {
            return Response.ok().entity(item.get()).build();
        }

        throw new EntityNotFoundException("Item not found");
    }

    @DELETE
    @Path("{id}")
    public Response destroy(@PathParam("id") Long ID) {
        itemService.delete(ID);

        return Response.ok().build();
    }
}
