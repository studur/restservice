package com.telagene.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.telagene.rest.model.Book;
import com.telagene.rest.model.Bookshelf;


@Path("/books/")
public class BooksResources {


   @GET
   @Path("{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Book getIt(@PathParam("id") String id) {
      return Bookshelf.getBook(Integer.parseInt(id));
   }
}