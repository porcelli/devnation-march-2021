package me.porcelli.devnation.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/application")
public class Application {

    @Inject
    private CanDriveService canDriveService;

    @Inject
    private RoadTestService roadTestService;

    @Inject 
    private DriversLicenseEmitionService driversLicenseEmitionService;

    @POST
    @Path("/apply")
    public RoadTestStatus apply(Applicant applicant) {
        if (!canDriveService.canDrive(applicant)){
            throw new ApplicantCantDriveException("Applicant can't drive!");
        }

        return roadTestService.requestRoadTest(applicant);
    }

    @GET
    @Path("/status/{id}")
    public RoadTestStatus status(@PathParam String id) {
        return roadTestService.status(id);
    }

    @POST
    @Path("/schedule/{id}")
    public void schedule(@PathParam String id) {
        roadTestService.schedule(id);
    }

    @POST
    @Path("/pass/{id}")
    public void pass(@PathParam String id) {
        Applicant applicant = roadTestService.passTest(id);
        driversLicenseEmitionService.emit(applicant);
    }

    @POST
    @Path("/fail/{id}")
    public void fail(@PathParam String id) {
        roadTestService.failTest(id);
    }

}
