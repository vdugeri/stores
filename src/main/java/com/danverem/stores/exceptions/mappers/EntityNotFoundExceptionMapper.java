package com.danverem.stores.exceptions.mappers;

import com.danverem.stores.utils.ErrorResponse;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException exception) {
        return Response
            .status(Response.Status.NOT_FOUND)
            .entity(new ErrorResponse(exception.getMessage()))
            .build();
    }
}
