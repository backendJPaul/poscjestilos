package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
    public Category findById(int id);
    public Category save(Category _category);
    public Category update(Category _category);
    public void delete(int id);
}
