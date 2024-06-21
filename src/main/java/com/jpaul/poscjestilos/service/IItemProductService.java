package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.ItemProduct;

import java.util.List;

public interface IItemProductService {
    List<ItemProduct> findAll();
    ItemProduct findById(Integer _id);
    ItemProduct save(ItemProduct _itemProduct);
    ItemProduct update(ItemProduct _itemProduct);
    void delete(Integer _id);

}
