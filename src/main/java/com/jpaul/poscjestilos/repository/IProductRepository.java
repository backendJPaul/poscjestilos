package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
