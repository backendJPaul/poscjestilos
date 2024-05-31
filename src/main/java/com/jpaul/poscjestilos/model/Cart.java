package com.jpaul.poscjestilos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "cart_item_id")
    private List<CartItem> cartItemList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
