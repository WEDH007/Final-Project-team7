package com.bookstore.browsing.book;

import com.bookstore.browsing.Author.Author;
import com.bookstore.browsing.Publisher.Publisher;

public class BookResponse {
/*    private int id;
    private String title;
    private Author author;
    private Publisher publisher;
    private String genre;
    private double rating;
    private double price;
    private Integer salescount;
    */
	
    private int id;
    private String title;
    private String authorName;
    private String publisherName;
    private String genre;
    private double rating;
    private double price;
    private Integer salescount;

    // Constructor, getters, and setters

    // Example constructor
  /*  public BookResponse(int id, String title, Author author, Publisher publisher, String genre, double rating, double price, Integer salescount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
        this.salescount = salescount;
    }*/
    
    public BookResponse(int id, String title, Author author, Publisher publisher, String genre, double rating, double price, Integer salescount) {
        this.id = id;
        this.title = title;
        this.authorName = author != null ? author.getName() : null;
        this.publisherName = publisher != null ? publisher.getName() : null;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
        this.salescount = salescount;
    }
}
