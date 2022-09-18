package com.ukim.mk.projectspring.Service;

import com.ukim.mk.projectspring.model.Cream;
import com.ukim.mk.projectspring.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Cream> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    public ShoppingCart addProductToShoppingCart(String username, Integer productId);
}
