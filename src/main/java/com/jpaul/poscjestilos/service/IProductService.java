package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer _id);
    Product save(Product _product);
    Product update(Product _product);

    void delete(Integer id);

}
