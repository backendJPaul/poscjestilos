package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
