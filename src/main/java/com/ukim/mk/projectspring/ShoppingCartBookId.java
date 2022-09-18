package com.ukim.mk.projectspring;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShoppingCartBookId implements Serializable {
    private static final long serialVersionUID = -7621249352132605051L;
    @Column(name = "shopping_cart_id", nullable = false)
    private Integer shoppingCartId;
    @Column(name = "cream_cream_id", nullable = false)
    private Integer creamCreamId;

    public Integer getCreamCreamId() {
        return creamCreamId;
    }

    public void setCreamCreamId(Integer creamCreamId) {
        this.creamCreamId = creamCreamId;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creamCreamId, shoppingCartId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShoppingCartBookId entity = (ShoppingCartBookId) o;
        return Objects.equals(this.creamCreamId, entity.creamCreamId) &&
                Objects.equals(this.shoppingCartId, entity.shoppingCartId);
    }
}