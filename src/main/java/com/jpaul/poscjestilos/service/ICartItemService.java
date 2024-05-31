package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.CartItem;
import com.jpaul.poscjestilos.model.Product;

import java.util.List;

public interface ICartItemService {
    List<CartItem> findAll();
    CartItem findById(int _id);
    CartItem save(CartItem cartItem);
    CartItem update(CartItem cartItem);
    void delete(int _id);
}
