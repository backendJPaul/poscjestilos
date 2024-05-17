package com.jpaul.poscjestilos.service;

import com.jpaul.poscjestilos.exception.ResourceNotFoundException;
import com.jpaul.poscjestilos.model.Category;
import com.jpaul.poscjestilos.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService{

    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        Optional<Category> categoryOptional = iCategoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Resource not found by Id" + id);
        }
    }

    @Override
    public Category save(Category _category) {
        return iCategoryRepository.save(_category);
    }

    @Override
    public Category update(Category _category) {
        Optional<Category> categoryOptional = iCategoryRepository.findById(_category.getId());
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            category.setName(_category.getName());

            return iCategoryRepository.save(category);
        }
        else{
            throw new ResourceNotFoundException("Resource not found exception " + _category.getId());
        }
    }

    @Override
    public void delete(int id) {
        Optional<Category> categoryOptional = iCategoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            iCategoryRepository.delete(categoryOptional.get());
        }
        else{
            throw new ResourceNotFoundException("Resource not found exception" + id);
        }
    }
}
