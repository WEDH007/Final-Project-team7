package com.bookstore.controller;

import com.bookstore.model.Wishlist;
import com.bookstore.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;
    @PostMapping("/create")
    public ResponseEntity<String> createWishlist(@RequestParam Long userId, @RequestBody String wishlist) {
        try {
            wishlistService.createWishlist(wishlist, userId.intValue());
            return ResponseEntity.ok("Wishlist created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating wishlist: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getWishlist(@RequestParam int id) {
        Optional<Wishlist> wishlist = wishlistService.getWishlist(id);
        if (wishlist.isPresent()) {
            return ResponseEntity.ok(wishlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestParam int id, @RequestParam int bookId) {
        try {
            wishlistService.addBookToWishlist(bookId, id);
            return ResponseEntity.ok("Book added to wishlist successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding book to wishlist: " + e.getMessage());
        }
    }

    @DeleteMapping("/removeBook")
    public ResponseEntity<String> removeBook(@RequestParam int id, @RequestParam int bookId) {
        try {
            wishlistService.removeBookFromWishlist(bookId, id);
            return ResponseEntity.ok("Book removed from wishlist successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error removing book from wishlist: " + e.getMessage());
        }
    }
}
