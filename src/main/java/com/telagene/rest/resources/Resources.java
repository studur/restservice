package com.telagene.rest.resources;


import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Resources {

   @GET
   @Path("status")
   @Produces(MediaType.TEXT_PLAIN)
   public String getIt() {
      LocalDateTime localDateTime = LocalDateTime.now();
      return "Running as of "+localDateTime.toString();
   }
}