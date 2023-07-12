package com.bookstore.browsing.Publisher;



import jakarta.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "publisher_name")
    private String name;

    // Getters and Setters
}
