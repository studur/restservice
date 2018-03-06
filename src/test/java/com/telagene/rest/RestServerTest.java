package com.telagene.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.telagene.rest.model.Book;
import com.telagene.rest.model.Bookshelf;

import static org.junit.Assert.assertTrue;

public class RestServerTest {

   private HttpServer server;
   private WebTarget target;

   @Before
   public void setUp() throws Exception {
      Bookshelf bookshelf = new Bookshelf();
      bookshelf.addBook(new Book("Dune", "Frank Herbert"));
      bookshelf.addBook(new Book("La guerre des mondes", "H. G. Wells"));

      new RestServer(bookshelf);

      server = RestServer.startServer();

      Client client = ClientBuilder.newClient();
      target = client.target(RestServer.BASE_URI);
   }

   @Test
   public void testRestServiceAtStatusPath() {
      String response = target.path("status").request().get(String.class);
      assertTrue(response.contains("Running"));
   }

   @Test
   public void testRestServiceAtBookPath() {
      Book response = target.path("books/1").request().get(Book.class);
      assertTrue(response.toString().contains("Book{title="));
   }

   @Test
   public void testRestServiceAtBooksPath() {
      String response = target.path("books/").request().get(String.class);
      assertTrue(response.toString().contains("Dune"));
   }

   @Test
   public void testRestServiceAtAddBookPath() {
      Book book = new Book("Les trois mousquetaires", "Alexandre Dumas");
      target.path("books/book").request().post(Entity.json(book));
      String response = target.path("books/").request().get(String.class);
      assertTrue(response.contains("Dumas"));
   }

   @After
   public void tearDown() throws Exception {
      server.shutdown();
   }

}