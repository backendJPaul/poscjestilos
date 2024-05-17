package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll();
    Brand findById(int _id);
    Brand save(Brand _brand);
    Brand update(Brand _brand);
    void delete(int _id);
}
