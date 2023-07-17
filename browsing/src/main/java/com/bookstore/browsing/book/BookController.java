package com.bookstore.browsing.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookstore.browsing.Publisher.PublisherService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }
    
 // Retrieve all books
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    // Retrieve List of Books by Genre
    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/top-sellers")
    public List<Book> getTopSellingBooks() {
        return bookService.getTopSellingBooks(10);
    }

    // Retrieve List of Books for a particular rating and higher
    @GetMapping("/rating/{rating}")
    public List<Book> getBooksByRating(@PathVariable float rating) {
        return bookService.getBooksByRating(rating);
    }
    @GetMapping("/publisher/{publisherName}")
    public List<Book> getBooksByPublisher(@PathVariable String publisherName) {
        return bookService.getBooksByPublisher(publisherName);
    }
    // Discount books by publisher
    @PutMapping("/discount")
    public void discountBooksByPublisher(@RequestParam double discount, @RequestParam String publisherName) {
        bookService.discountBooksByPublisher(discount, publisherName);
    }
}
