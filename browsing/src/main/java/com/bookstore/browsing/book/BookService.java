package com.bookstore.browsing.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
    
 // In BookService class
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

	/*
	 * public List<Book> getTopSellers() { // You would need to track sales data in
	 * your model to implement this method }
	 */

    public List<Book> getBooksByRating(float rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
    
    public List<Book> getBooksByPublisher(String publisherName) {
        return bookRepository.findByPublisherName(publisherName);
    }

    public void discountBooksByPublisher(double discount, String publisherName) {
        List<Book> books = bookRepository.findByPublisherName(publisherName);
        for(Book book : books) {
            double newPrice = book.getPrice() * (1 - discount / 100);
            book.setPrice(newPrice);
            bookRepository.save(book);
        }
    }

/*	public List<Book> getTopSellers() {
		// TODO Auto-generated method stub
		return null;*/
	

}
