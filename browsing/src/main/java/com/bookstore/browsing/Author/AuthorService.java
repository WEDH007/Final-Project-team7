package com.bookstore.browsing.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public Author getAuthorById(int authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

    // You can now use authorRepository to interact with the database
}
