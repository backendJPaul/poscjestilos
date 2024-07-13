package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {

}
