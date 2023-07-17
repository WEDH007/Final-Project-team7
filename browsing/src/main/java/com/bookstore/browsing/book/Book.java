package com.bookstore.browsing.book;



import com.bookstore.browsing.Author.Author;
import com.bookstore.browsing.Publisher.Publisher;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

	@Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private double rating;

    @Column(name = "price")
    private double price;
    
    @Column(name = "salescount")
    private Integer salescount;


	public Integer getSalescount() {
		return salescount;
	}

	public void setSalescount(Integer salescount) {
		this.salescount = salescount;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	public void setPrice(double newPrice) {
		// TODO Auto-generated method stub
		this.price = newPrice;
	}
	
    @Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", genre="
				+ genre + ", rating=" + rating + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

    // getters and setters
}
