package com.networkMapping.installationLocation.controllers.exceptionsMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.networkMapping.shared.exceptions.NotFoundEntityException;

@Provider
public class NotFoundEntityExceptionMapper implements ExceptionMapper<NotFoundEntityException> {

    @Override
    public Response toResponse(NotFoundEntityException exception) {
        var responseError = new HttpMessageError("Not found", exception.getMessage());
        return Response.status(Status.NOT_FOUND).entity(responseError).build();
    }

}
