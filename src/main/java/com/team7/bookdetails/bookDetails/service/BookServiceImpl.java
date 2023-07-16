package com.team7.bookdetails.bookDetails.service;

import com.team7.bookdetails.authorDetails.repository.AuthorRepository;
import com.team7.bookdetails.bookDetails.model.Book;
import com.team7.bookdetails.bookDetails.repository.BookRepository;
import com.team7.bookdetails.authorDetails.model.Author;
import com.team7.bookdetails.authorDetails.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}