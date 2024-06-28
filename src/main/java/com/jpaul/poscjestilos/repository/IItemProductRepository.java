package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.ItemProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IItemProductRepository extends JpaRepository<ItemProduct, Integer> {
    List<ItemProduct> findByProductId(Integer id);

}
