package com.bookstore.repository;

import com.bookstore.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    Optional<Wishlist> findByNameAndUserId(String name, int userId);
}
