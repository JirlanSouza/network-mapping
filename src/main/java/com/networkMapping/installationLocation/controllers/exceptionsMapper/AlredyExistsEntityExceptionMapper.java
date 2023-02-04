package com.networkMapping.installationLocation.controllers.exceptionsMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;

@Provider
public class AlredyExistsEntityExceptionMapper implements ExceptionMapper<AlreadyExistsEntityException> {

    @Override
    public Response toResponse(AlreadyExistsEntityException exception) {
        var responseError = new HttpResponseError("Conflict", exception.getMessage());
        return Response.status(Status.CONFLICT).entity(responseError).build();
    }

}
