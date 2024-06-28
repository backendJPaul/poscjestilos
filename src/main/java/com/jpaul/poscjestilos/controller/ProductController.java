package com.jpaul.poscjestilos.controller;

import com.jpaul.poscjestilos.model.Product;
import com.jpaul.poscjestilos.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@AllArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController{

    private IProductService iProductService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(iProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer _id) {
        return new ResponseEntity<>(iProductService.findById(_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product _product) {
        return new ResponseEntity<>(iProductService.save(_product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody Product _product) {
        return new ResponseEntity<>(iProductService.update(_product), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable("id") Integer id) {
        iProductService.delete(id);
        return HttpStatus.OK;
    }
}
