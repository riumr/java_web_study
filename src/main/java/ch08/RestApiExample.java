package ch08;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class RestApiExample {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String SayHello(){
    return "Hello API Service";
  }

  @POST
  public String SayHello(@QueryParam("msg") String msg){
    return msg+" API Service";
  }
}
