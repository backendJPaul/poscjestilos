package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.User;

import java.util.List;

public interface IUserService{

    List<User> findAll();
    User findById(int _id);
    User save(User _user);
    User update(User _user);
    void delete(int _id);
}
