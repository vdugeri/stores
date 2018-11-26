package com.danverem.stores.controllers;

import com.danverem.stores.dtos.DesignationDTO;
import com.danverem.stores.services.DesignationService;
import com.danverem.stores.validators.DesignationValidator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/designations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@LocalBean
public class DesignationController {

    @Inject
    private DesignationService service;

    @Inject
    private DesignationValidator validator;

    @GET
    public Response index() {
        List<DesignationDTO> designations = service.getAll();

        return Response.ok().entity(designations).build();
    }

    @POST
    public Response store(DesignationDTO designationDTO) {
        String error = validator.validateCode(designationDTO);

        if (error != null) {
            throw new EntityExistsException("Designation already exists");
        }

        DesignationDTO designation = service.create(designationDTO);

        return Response.status(Response.Status.CREATED).entity(designation).build();
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long ID) {
        Optional<DesignationDTO> designation = service.find(ID);

        if (designation.isPresent()) {
            return Response.ok().entity(designation.get()).build();
        }

        throw new EntityNotFoundException("Designation not found");
    }

    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Long ID, DesignationDTO designationDTO) {
        Optional<DesignationDTO> designation = service.edit(ID, designationDTO);

        if (designation.isPresent()) {
            return Response.ok().entity(designation.get()).build();
        }

        throw new EntityNotFoundException("Designation not found");
    }

    @DELETE
    @Path("{id}")
    public Response destroy(@PathParam("id") Long ID) {
        service.delete(ID);

        return Response.ok().build();
    }
}
