package com.telagene.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for...
 */
public class Bookshelf {

   public static final List<Book> books = new ArrayList<>();


   public Bookshelf() {
   }

   public static Book getBook(int id) {
      return books.get(id);
   }

   public static void addBook(Book book) {
      books.add(book);
   }

   public static List<Book> getBooks() {
      return books;
   }
}
