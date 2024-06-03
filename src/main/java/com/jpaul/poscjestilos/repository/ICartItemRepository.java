package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {

}
