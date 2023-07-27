    package com.bookstore.model;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.*;
    import java.util.List;

    @Entity
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String username;

        @OneToMany(mappedBy = "user")
        private List<Wishlist> wishlists;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public List<Wishlist> getWishlists() { return wishlists; }
        public void setWishlists(List<Wishlist> wishlists) { this.wishlists = wishlists; }


    }
