package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Sale;

import java.util.List;

public interface ISaleService {
    List<Sale> findAll();
    Sale findById(Integer _id);
    Sale save(Sale sale);
    Sale update(Sale sale);
    void delete(Integer _id);
}
