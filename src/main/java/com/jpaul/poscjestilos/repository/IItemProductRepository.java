package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.ItemProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemProductRepository extends JpaRepository<ItemProduct, Integer> {

}
