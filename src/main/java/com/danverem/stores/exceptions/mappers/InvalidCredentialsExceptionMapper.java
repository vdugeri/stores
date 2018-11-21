package com.danverem.stores.exceptions.mappers;

import com.danverem.stores.exceptions.InvalidCredentialsException;
import com.danverem.stores.utils.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidCredentialsExceptionMapper implements ExceptionMapper<InvalidCredentialsException> {
    @Override
    public Response toResponse(InvalidCredentialsException exception) {
        return Response
            .status(Response.Status.UNAUTHORIZED)
            .entity(new ErrorResponse(exception.getMessage()))
            .build();
    }
}
