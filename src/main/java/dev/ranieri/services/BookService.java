package dev.ranieri.services;

import dev.ranieri.entities.Book;

import java.util.List;

public interface BookService {

    Book registerBook(Book book);

    List<Book> getAllBooks();
    Book getBookById(int id);

    Book checkinBook(int id);
    Book checkoutBook(int id);

}
