package com.BookStore.restdemo.model;

public class Book {
    private String title;
    private String author;

    private String genre;

    private Integer year;
    private Integer edition;

    private Double price;

    public Book() {
    }

    public Book(String bookTitle, String bookAuthor, String bookGenre, Integer bookYear, Integer bookEdition, Double bookPrice) {
        title = bookTitle;
        author = bookAuthor;
        genre = bookGenre;
        year = bookYear;
        edition = bookEdition;
        price = bookPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    }

