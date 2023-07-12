package com.bookstore.browsing.Author;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String name;

    // getters and setters
}
