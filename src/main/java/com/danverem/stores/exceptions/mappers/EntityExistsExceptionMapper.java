package com.danverem.stores.exceptions.mappers;

import com.danverem.stores.utils.ErrorResponse;
import javax.persistence.EntityExistsException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityExistsExceptionMapper implements ExceptionMapper<EntityExistsException> {
    @Override
    public Response toResponse(EntityExistsException exception) {
        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(new ErrorResponse(exception.getMessage()))
            .build();
    }
}
