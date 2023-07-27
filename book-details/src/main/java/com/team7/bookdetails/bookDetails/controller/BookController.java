package src.main.java.com.team7.bookdetails.bookDetails.controller;

import src.main.java.com.team7.bookdetails.bookDetails.model.Book;
import src.main.java.com.team7.bookdetails.bookDetails.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        
        bookService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}