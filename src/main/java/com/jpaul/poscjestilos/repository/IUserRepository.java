package com.jpaul.poscjestilos.repository;

import com.jpaul.poscjestilos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {


}
