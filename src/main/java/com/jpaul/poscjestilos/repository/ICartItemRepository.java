package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {

}
