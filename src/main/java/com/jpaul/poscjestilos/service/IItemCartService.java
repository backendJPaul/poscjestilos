package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.ItemCart;

import java.util.List;

public interface IItemCartService {
    List<ItemCart> findAll();
    ItemCart findById(int _id);
    ItemCart save(ItemCart itemCart);
    ItemCart update(ItemCart itemCart);
    void delete(int _id);
}
