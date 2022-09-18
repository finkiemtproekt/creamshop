package com.ukim.mk.projectspring.repo;

import com.ukim.mk.projectspring.model.ShoppingCart;
import com.ukim.mk.projectspring.model.Users;
import com.ukim.mk.projectspring.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserAndStatus(Users user, ShoppingCartStatus status);
}