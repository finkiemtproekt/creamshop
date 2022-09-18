package com.ukim.mk.projectspring;

import com.ukim.mk.projectspring.model.Cream;
import com.ukim.mk.projectspring.model.ShoppingCart;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart_books")
public class ShoppingCartBook {
    @EmbeddedId
    private ShoppingCartBookId id;

    @MapsId("shoppingCartId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;

    @MapsId("creamCreamId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cream_cream_id", nullable = false)
    private Cream creamCream;

    public Cream getCreamCream() {
        return creamCream;
    }

    public void setCreamCream(Cream creamCream) {
        this.creamCream = creamCream;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCartBookId getId() {
        return id;
    }

    public void setId(ShoppingCartBookId id) {
        this.id = id;
    }
}