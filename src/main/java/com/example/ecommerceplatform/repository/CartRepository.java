package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cart (user_id, product_id) VALUES (?1, ?2)", nativeQuery = true)
    void addToCart(Long userId, Long productId);

    @Query(value = "SELECT p.* FROM products p INNER JOIN cart c ON p.id = c.product_id WHERE c.user_id = ?1", nativeQuery = true)
    List<Product> findCartItemsByUserId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart WHERE user_id = ?1", nativeQuery = true)
    void clearCart(Long userId);
}
