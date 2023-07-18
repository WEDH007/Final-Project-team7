package src.main.java.com.team7.bookdetails.authorDetails.service;

import src.main.java.com.team7.bookdetails.authorDetails.model.Author;
import src.main.java.com.team7.bookdetails.bookDetails.model.Book;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Book> getBooksByAuthor(Long authorId);
}