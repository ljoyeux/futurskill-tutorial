package fr.futurskill.tutorial.rs;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class SimpleService {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
        return "hello " + firstName + " " + lastName;
    }

    @Path("/hello")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(Account account) {
        return "hello " + account.getFirstName() + " " + account.getLastName();
    }
}
