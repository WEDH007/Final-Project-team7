package com.team7.bookdetails.bookDetails.repository;
import java.util.List;
import com.team7.bookdetails.bookDetails.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book> findByAuthor_Id(Long authorId);
}