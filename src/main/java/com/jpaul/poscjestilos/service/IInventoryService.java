package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Inventory;

import java.util.List;

public interface IInventoryService {
    List<Inventory> findAll();
    Inventory findById(Integer _id);
    Inventory save(Inventory inventory);
    Inventory update(Inventory inventory);
    void delete(Integer _id);
}
