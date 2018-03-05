/*
 * Code adapted from Oracle tutorials and jersey.github.io
 */

package com.telagene.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

import com.telagene.rest.model.Book;
import com.telagene.rest.model.Bookshelf;

public class RestService {
   // Base URI the Grizzly HTTP server will listen on
   public static final String BASE_URI = "http://localhost:8088/rest/";

   public static HttpServer startServer() {
      // create a resource config that scans for JAX-RS resources and providers
      // in com.telagene.rest package
      final ResourceConfig rc = new ResourceConfig().packages("com.telagene.rest");

      // Add a couple books to test JSON serialization
      Bookshelf.addBook(new Book("Dune", "Frank Herbert"));
      Bookshelf.addBook(new Book("La guerre des mondes", "H. G. Wells"));

      // create and start a new instance of grizzly http server
      // exposing the Jersey application at BASE_URI
      return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
   }

   public static void main(String[] args) throws IOException {
      startServer();
   }
}