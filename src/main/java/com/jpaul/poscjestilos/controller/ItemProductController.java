package com.jpaul.poscjestilos.controller;


import com.jpaul.poscjestilos.model.ItemProduct;
import com.jpaul.poscjestilos.service.IItemProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@AllArgsConstructor
@RequestMapping("api/itemproduct")

public class ItemProductController{

    private IItemProductService iItemProductService;

    @GetMapping
    public ResponseEntity<List<ItemProduct>> findAll() {
        return new ResponseEntity<>(iItemProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProduct> findById(@PathVariable("id") Integer _id) {
        return new ResponseEntity<>(iItemProductService.findById(_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemProduct> save(@RequestBody ItemProduct _itemProduct) {
        return new ResponseEntity<>(iItemProductService.save(_itemProduct), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemProduct> update(@PathVariable("id") int id, @RequestBody ItemProduct _itemProduct) {
        return new ResponseEntity<>(iItemProductService.update(_itemProduct), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Integer _id) {
        iItemProductService.delete(_id);
        return HttpStatus.OK;
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<List<ItemProduct>> findByProductId(@PathVariable("id") Integer _id){
         return new ResponseEntity<>(iItemProductService.findByProductId(_id), HttpStatus.OK);
    }
}
