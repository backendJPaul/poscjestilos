package com.jpaul.poscjestilos.controller;


import com.jpaul.poscjestilos.model.Category;
import com.jpaul.poscjestilos.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController{

    private ICategoryService iCategoryService;


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = iCategoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(iCategoryService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category _category) {
        return new ResponseEntity<>(iCategoryService.save(_category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody Category _category) {
        return new ResponseEntity<>(iCategoryService.update(_category), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable int id) {
        iCategoryService.delete(id);
        return HttpStatus.OK;
    }
}
