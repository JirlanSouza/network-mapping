package com.networkMapping.installationLocation.controllers.exceptionsMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AllExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        var responseError = new HttpMessageError("Internal server error", exception.getMessage());
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(responseError).build();
    }

}
