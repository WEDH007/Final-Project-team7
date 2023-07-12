package com.bookstore.browsing.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	// In BookRepository interface
	List<Book> findByGenre(String genre);
	List<Book> findByRatingGreaterThanEqual(float rating);
	List<Book> findByPublisherName(String publisherName);
	
}
