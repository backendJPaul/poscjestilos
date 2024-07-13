package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IColorRepository extends JpaRepository<Color, Integer> {

}
