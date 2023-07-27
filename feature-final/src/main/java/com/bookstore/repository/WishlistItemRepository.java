package com.bookstore.repository;

import com.bookstore.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Integer> {
    Optional<WishlistItem> findByWishlistIdAndBookId(int wishlistId, int bookId);
    Optional<List<WishlistItem>> findByWishlistId(int wishlistId);
}
