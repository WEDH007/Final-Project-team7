package com.team7.bookdetails.authorDetails.controller;
import com.team7.bookdetails.authorDetails.model.Author;
import com.team7.bookdetails.authorDetails.service.AuthorService;
import com.team7.bookdetails.bookDetails.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getBooksByAuthor(id));
    }
}
