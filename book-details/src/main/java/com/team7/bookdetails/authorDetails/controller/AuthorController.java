package src.main.java.com.team7.bookdetails.authorDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.team7.bookdetails.authorDetails.model.Author;
import src.main.java.com.team7.bookdetails.authorDetails.service.AuthorService;
import src.main.java.com.team7.bookdetails.bookDetails.model.Book;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getBooksByAuthor(id));
    }
}
