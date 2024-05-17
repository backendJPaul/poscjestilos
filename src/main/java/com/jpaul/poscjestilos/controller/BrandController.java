package com.jpaul.poscjestilos.controller;

import com.jpaul.poscjestilos.model.Brand;
import com.jpaul.poscjestilos.service.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brand")

public class BrandController{

    private IBrandService iBrandService;

    @GetMapping
    public ResponseEntity<List<Brand>> findAll() {
        return new ResponseEntity<>(iBrandService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> findById(@PathVariable("id") int _id) {
        return new ResponseEntity<>(iBrandService.findById(_id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody Brand _brand) {
        return new ResponseEntity<>(iBrandService.save(_brand), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable("id") int id, @RequestBody Brand _brand) {
        return new ResponseEntity<>(iBrandService.update(_brand),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int _id) {
       iBrandService.delete(_id);
       return HttpStatus.OK;
    }
}
