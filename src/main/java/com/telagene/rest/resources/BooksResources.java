package com.telagene.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.telagene.rest.dataservices.LibraryService;
import com.telagene.rest.model.Book;


@Path("/books/")
public class BooksResources {


   @GET
   @Path("{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Book getIt(@PathParam("id") String id) {
      return LibraryService.getBook(id);
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Book> getBooks() {
      return LibraryService.getBooks();
   }

   @POST
   @Path("book")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response addBook(Book book) {
      LibraryService.addBook(book);
      return Response.status(201).build();
   }

}