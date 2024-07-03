package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Material;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Integer> {
}
