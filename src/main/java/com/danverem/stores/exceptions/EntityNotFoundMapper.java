package com.danverem.stores.exceptions;

import com.danverem.stores.utils.ErrorResponse;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException exception) {
        return Response
            .status(Response.Status.NOT_FOUND)
            .entity(new ErrorResponse("Not found"))
            .build();
    }
}
