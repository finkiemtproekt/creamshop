package com.ukim.mk.projectspring.model;

import com.ukim.mk.projectspring.model.enumerations.ShoppingCartStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_created")
    private LocalDateTime dateCreated;

    @ManyToOne
    private Users user;

    @ManyToMany
    private List<Cream> cream;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    public ShoppingCart() {
    }

    public ShoppingCart(Users user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.cream = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
