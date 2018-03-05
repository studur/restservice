/*
 * Code adapted from Oracle tutorials and jersey.github.io
 */

package com.telagene.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class RestService {
   // Base URI the Grizzly HTTP server will listen on
   public static final String BASE_URI = "http://localhost:8088/rest/";

   public static HttpServer startServer() {
      // create a resource config that scans for JAX-RS resources and providers
      // in com.telagene.rest package
      final ResourceConfig rc = new ResourceConfig().packages("com.telagene.rest");

      // create and start a new instance of grizzly http server
      // exposing the Jersey application at BASE_URI
      return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
   }

   public static void main(String[] args) throws IOException {
      startServer();
   }
}