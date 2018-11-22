package com.danverem.stores.exceptions.mappers;

import com.danverem.stores.exceptions.TakenException;
import com.danverem.stores.utils.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NameAlreadyTakenExceptionMapper implements ExceptionMapper<TakenException> {
    @Override
    public Response toResponse(TakenException exception) {
        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(new ErrorResponse(exception.getMessage()))
            .build();
    }
}
