package com.telagene.rest.dataservices;

import java.util.List;

import com.telagene.rest.model.Book;
import com.telagene.rest.model.Bookshelf;

/**
 * This class is responsible for...
 */
public class LibraryService {

   private static Bookshelf bookshelf;

   public static void setBookshelf(Bookshelf bookshelf) {
      LibraryService.bookshelf = bookshelf;
   }

   public static void addBook(Book book) {
      LibraryService.bookshelf.addBook(book);
    }

   public static List<Book> getBooks() {
      return LibraryService.bookshelf.getBooks();
   }

   public static Book getBook(String id){
      return LibraryService.bookshelf.getBook(Integer.parseInt(id));
   }

}
