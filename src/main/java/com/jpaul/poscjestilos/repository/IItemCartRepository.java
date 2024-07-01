package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemCartRepository extends JpaRepository<ItemCart, Integer> {

}
