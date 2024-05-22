package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryRepository extends JpaRepository<Inventory, Integer> {
}
