package com.BookStore.restdemo.controller;
import com.BookStore.restdemo.model.Book;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    private List<Book> books = new ArrayList<>();


    @GetMapping("/books") // Change the GET request mapping to /books
    public List<Book> getBooks() {
        // Return the existing list of books
        return books;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book newBook) {
        books.add(newBook);
        return newBook;
    }

    @PostMapping("/books/book1")
    public Book addBook1() {
        Book book1 =  new Book("Biology", "Oppenheimer", "Educational", 2023, 1, 49.99);
        books.add(book1);
        return book1;
    }

    @PostMapping("/books/book2")
    public Book addBook2() {
        Book book2 = new Book("Shrek", "Dreamworks", "Fantasy", 2019, 2, 19.99);
        books.add(book2);
        return book2;
    }

    @PostMapping("/books/book3")
    public Book addBook3() {
        Book book3 = new Book("Pokemon", "Nintendo", "Adventure", 1999, 4, 34.99);
        books.add(book3);
        return book3;
    }

    @DeleteMapping("/deleteBook/{title}") // Change the DELETE request mapping to /deleteBook/{title}
    public Book deleteBook(@PathVariable String title) {
        // Find the book with the given title in the list
        Book deletedBook = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                deletedBook = book;
                break;
            }
        }

        // If the book is found, remove it from the list
        if (deletedBook != null) {
            books.remove(deletedBook);
        }

        return deletedBook;
    }

    @GetMapping("/sumOfPrices")
    public double getSumOfPrices() {
        double sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum;
    }




























}
