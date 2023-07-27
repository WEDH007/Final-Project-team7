package com.bookstore.model;

import javax.persistence.*;

import java.util.List;

@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "wishlist")
    private List<WishlistItem> wishlistItems;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<WishlistItem> getWishlistItems() { return wishlistItems; }
    public void setWishlistItems(List<WishlistItem> wishlistItems) { this.wishlistItems = wishlistItems; }
}
