package com.bookstore;

import com.bookstore.model.User;
import com.bookstore.model.Book;
import com.bookstore.model.Wishlist;
import com.bookstore.model.WishlistItem;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.repository.WishlistItemRepository;
import com.bookstore.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("ChrisFranco");
        userRepository.save(user1);

        Book book1 = new Book();
        book1.setId(5);
        book1.setTitle("PercyJackson");
        bookRepository.save(book1);

        WishlistItem mrWishItems = new WishlistItem();
        mrWishItems.setId(1);
        mrWishItems.setBook(book1);

        Wishlist mrWish = new Wishlist();
        mrWish.setId(4);

        List<WishlistItem> myList = new ArrayList<>();
        myList.add(mrWishItems);
        mrWish.setWishlistItems(myList);

    }
}
