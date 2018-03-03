package com.telagene.rest;


import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/* Root resource (exposed at "status" path) */
@Path("status")
public class Resources {

   @GET
   @Produces(MediaType.TEXT_PLAIN)
   public String getIt() {
      LocalDateTime localDateTime = LocalDateTime.now();
      return "Running as of "+localDateTime.toString();
   }
}