package com.danverem.stores.controllers;

import com.danverem.stores.dtos.PaginatedResource;
import com.danverem.stores.dtos.StoreDTO;
import com.danverem.stores.exceptions.TakenException;
import com.danverem.stores.mappers.StoreMapper;
import com.danverem.stores.models.Store;
import com.danverem.stores.services.StoreService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Stateless
@LocalBean
@Path("/stores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StoreController {

    @Inject
    private StoreService storeService;

    @GET
    public Response index(@DefaultValue("50") @QueryParam("limit") Integer limit, @DefaultValue("0") @QueryParam("offset") Integer offset) {
        PaginatedResource<StoreDTO> stores = storeService.getAll(limit, offset);

        return Response.ok().entity(stores).build();
    }

    @POST
    public Response store(StoreDTO storeDTO) throws TakenException {
        Store store = storeService.create(storeDTO);

        return Response
            .status(Response.Status.CREATED)
            .entity(StoreMapper.mapTo(store))
            .build();
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long ID) {
        Optional<Store> store = storeService.find(ID);

        if (store.isPresent()) {
            return Response.ok().entity(StoreMapper.mapTo(store.get())).build();
        }

        throw new EntityNotFoundException("Store not found");
    }

    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Long ID, StoreDTO storeDTO) {
        Store store = storeService.edit(ID, storeDTO);

        return Response.ok().entity(StoreMapper.mapTo(store)).build();
    }


    @DELETE
    @Path("{id}")
    public Response destroy(@PathParam("id") Long ID) {
        storeService.delete(ID);

        return Response.ok().build();
    }
}
