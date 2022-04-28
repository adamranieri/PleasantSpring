package dev.ranieri.controllers;

import dev.ranieri.entities.Book;
import dev.ranieri.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller // stereotype for spring. This class is used as generate a bean that defines API routes for my web server
public class BookController {

    @Autowired // will try to find a bean that can be injected here
    private BookService bookService;

    @GetMapping("/books") // spring will generate a route /books that when a get is sent there this method will be called
    @ResponseBody // converts the return into a JSON for the HTTP response
    public List<Book> retrieveAllBooks(){
        List<Book> books = this.bookService.getAllBooks();
        return books;
    }

    @GetMapping("/books/{id}") // param in string must match param in method signature
    @ResponseBody
    public Book retrieveBookById(@PathVariable int id){
        Book book = this.bookService.getBookById(id);
        return book;
    }

    @PostMapping("/books")
    @ResponseBody
    public Book createBook(@RequestBody Book book){ // will convert the JSON request body into an object
        return this.bookService.registerBook(book);
    }

    @PatchMapping("/books/{id}/checkout")
    @ResponseBody
    public Book checkoutBook(@PathVariable int id){
        Book book = this.bookService.checkoutBook(id);
        return book;
    }


}
