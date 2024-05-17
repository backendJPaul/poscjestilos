package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {
}
