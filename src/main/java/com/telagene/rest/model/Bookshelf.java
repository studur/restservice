package com.telagene.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for...
 */
public class Bookshelf {

   public final List<Book> books = new ArrayList<>();


   public Bookshelf() {
   }

   public Book getBook(int id) {
      return books.get(id);
   }

   public Book addBook(Book book) {
      books.add(book);
      return book;
   }

   public List<Book> getBooks() {
      return books;
   }
}
