package src.main.java.com.team7.bookdetails.authorDetails.repository;

import src.main.java.com.team7.bookdetails.authorDetails.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}
