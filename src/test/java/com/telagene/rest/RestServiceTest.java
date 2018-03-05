package com.telagene.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.telagene.rest.model.Book;

import static org.junit.Assert.assertTrue;

public class RestServiceTest {

   private HttpServer server;
   private WebTarget target;

   @Before
   public void setUp() throws Exception {
      server = RestService.startServer();
      Client client = ClientBuilder.newClient();
      target = client.target(RestService.BASE_URI);
   }

   @Test
   public void testRestServiceAtStatusPath() {
      String responseMsg = target.path("status").request().get(String.class);
      assertTrue(responseMsg.contains("Running"));
   }

   @Test
   public void testRestServiceAtBookPath() {
      Book responseMsg = target.path("books/1").request().get(Book.class);
      assertTrue(responseMsg.toString().contains("Book{title="));
   }

   @After
   public void tearDown() throws Exception {
      server.shutdown();
   }

}