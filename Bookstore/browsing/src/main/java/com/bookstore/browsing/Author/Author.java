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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



    // getters and setters
}
