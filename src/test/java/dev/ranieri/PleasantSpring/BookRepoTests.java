package dev.ranieri.PleasantSpring;

import dev.ranieri.entities.Book;
import dev.ranieri.repos.BookRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest // let spring know that this test file will use spring
public class BookRepoTests {

    @Autowired // Spring will attempt to find a bean that satisfies this field and inject it
    // a BookRepo implementation was never written by us. Spring DATA Jpa is able to read our annotated entity
    // to use refelction to AUTO-GENERATE an implementation class of bookRepo
    private BookRepo bookRepo;

    @Test
    public void createBook(){
        Book book = new Book(0,"Frankestein","Mary Shelley",0);
        bookRepo.save(book);
        System.out.println(book);
        Assertions.assertNotEquals(0,book.getId());

    }

    @Test
    public void getAllBooks(){
        List<Book> books = this.bookRepo.findAll();
        System.out.println(books);
    }

    @Test
    public void getBookById(){
        // Some methods return an optional
        // getting a book by id might or might not exist
        // an optional is a container that *might contain or might not// forces the developer to account for the
        // possiblity it does not exist
        Optional<Book> possibleBook = this.bookRepo.findById(51);
        if(possibleBook.isPresent()){
            Book book = possibleBook.get();
            System.out.println(book);
        }else{
            System.out.println("No book was returned");
        }

    }

    @Test
    public void findBooksByTitle(){
        List<Book> frankensteins = this.bookRepo.findBooksByTitle("Frankenstein");
        System.out.println(frankensteins);
    }

    @Test
    public void findBooksAuthor(){
        List<Book> frankensteins = this.bookRepo.findBooksByAuthor("Mary Shelley");
        System.out.println(frankensteins);
    }
}
