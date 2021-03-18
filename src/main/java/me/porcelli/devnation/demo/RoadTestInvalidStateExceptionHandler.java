package me.porcelli.devnation.demo;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RoadTestInvalidStateExceptionHandler implements ExceptionMapper<RoadTestInvalidStateException>  {
    @Override
    public Response toResponse(RoadTestInvalidStateException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
    }
}