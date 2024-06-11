package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
}
