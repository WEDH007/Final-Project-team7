package com.bookstore.model;

import javax.persistence.*;

@Entity
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="wishlist_id", nullable=false)
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Wishlist getWishlist() { return wishlist; }
    public void setWishlist(Wishlist wishlist) { this.wishlist = wishlist; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}
