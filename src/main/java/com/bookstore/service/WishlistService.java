package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.User;
import com.bookstore.model.Wishlist;
import com.bookstore.model.WishlistItem;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.repository.WishlistItemRepository;
import com.bookstore.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    public void createWishlist(String wishlistName, int userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            Wishlist newWishlist = new Wishlist();
            newWishlist.setName(wishlistName);
            newWishlist.setUser(userOptional.get());
            wishlistRepository.save(newWishlist);
        } else {
            throw new Exception("User not found with ID " + userId);
        }
    }

    public Optional<Wishlist> getWishlist(int wishlistId) {
        return wishlistRepository.findById(wishlistId);
    }

    public void addBookToWishlist(int bookId, int wishlistId) throws Exception {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(wishlistId);

        if (bookOptional.isPresent() && wishlistOptional.isPresent()) {
            WishlistItem newWishlistItem = new WishlistItem();
            newWishlistItem.setBook(bookOptional.get());
            newWishlistItem.setWishlist(wishlistOptional.get());
            wishlistItemRepository.save(newWishlistItem);
        } else {
            throw new Exception("Book or Wishlist not found with IDs " + bookId + " " + wishlistId);
        }
    }

    public void removeBookFromWishlist(int bookId, int wishlistId) throws Exception {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(wishlistId);

        if (wishlistOptional.isPresent()) {
            Optional<WishlistItem> wishlistItemOptional = wishlistItemRepository.findByWishlistIdAndBookId(wishlistId, bookId);

            if (wishlistItemOptional.isPresent()) {
                wishlistItemRepository.delete(wishlistItemOptional.get());
            } else {
                throw new Exception("WishlistItem not found for Wishlist and Book with IDs " + wishlistId + " " + bookId);
            }
        } else {
            throw new Exception("Wishlist not found with ID " + wishlistId);
        }
    }
}
