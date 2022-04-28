package dev.ranieri.services;

import dev.ranieri.entities.Book;
import dev.ranieri.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
@Service// say that is class does business logic
public class BookServiceImpl implements BookService {

    @Autowired// please inject the BookRepo into this implementation
    private BookRepo bookRepo;

    @Override
    public Book registerBook(Book book) {
        book.setReturnDate(0);
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book getBookById(int id) {
         Optional<Book> possibleBook = this.bookRepo.findById(id);

         if(possibleBook.isPresent()){
             return possibleBook.get();
         }else{
             throw new RuntimeException("UH OH no book found with id: " + id);
         }

    }

    @Override
    public Book checkinBook(int id) {
        Book book = this.getBookById(id);
        book.setReturnDate(0);
        this.bookRepo.save(book);// there is no specific update method for repos. Save just overwrites the entity if the id is the same
        return book;
    }

    @Override
    public Book checkoutBook(int id) {
        Book book = this.getBookById(id);
        book.setReturnDate(System.currentTimeMillis() +(1000*60*60*24*14));
        this.bookRepo.save(book);
        return book;
    }
}
