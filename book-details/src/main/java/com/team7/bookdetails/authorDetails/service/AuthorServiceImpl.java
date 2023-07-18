package src.main.java.com.team7.bookdetails.authorDetails.service;

import src.main.java.com.team7.bookdetails.authorDetails.model.Author;
import src.main.java.com.team7.bookdetails.authorDetails.repository.AuthorRepository;
import src.main.java.com.team7.bookdetails.bookDetails.model.Book;
import src.main.java.com.team7.bookdetails.bookDetails.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthor_Id(authorId);
    }
}
