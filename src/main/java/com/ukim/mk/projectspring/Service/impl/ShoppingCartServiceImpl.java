package com.ukim.mk.projectspring.Service.impl;

import com.ukim.mk.projectspring.Service.CreamService;
import com.ukim.mk.projectspring.Service.ShoppingCartService;
import com.ukim.mk.projectspring.model.Cream;
import com.ukim.mk.projectspring.model.ShoppingCart;
import com.ukim.mk.projectspring.model.Users;
import com.ukim.mk.projectspring.model.enumerations.ShoppingCartStatus;
import com.ukim.mk.projectspring.model.exceptions.ProductAlreadyInShoppingCartException;
import com.ukim.mk.projectspring.repo.ShoppingCartRepository;
import com.ukim.mk.projectspring.repo.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UsersRepository usersRepository;
    private final CreamService creamRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UsersRepository usersRepository, CreamService creamRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.usersRepository = usersRepository;
        this.creamRepository = creamRepository;
    }

    @Override
    public List<Cream> listAllProductsInShoppingCart(Long cartId) {
        return this.shoppingCartRepository.findById(cartId).get().getCream();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        Users user = this.usersRepository.findByUsername(username).get();

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Integer productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Cream product = this.creamRepository.findById(productId).get();
        if(shoppingCart.getCream()
                .stream().filter(i -> i.getCream_id().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getCream().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
