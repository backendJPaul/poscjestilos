package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();
    Cart findById(int _id);
    Cart save(Cart _cart);
    Cart update(Cart _cart);
    void delete(int _id);
}
