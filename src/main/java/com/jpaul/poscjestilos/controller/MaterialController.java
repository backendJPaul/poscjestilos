package com.jpaul.poscjestilos.controller;

import com.jpaul.poscjestilos.model.Material;
import com.jpaul.poscjestilos.service.IMaterialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@AllArgsConstructor
@RequestMapping("api/material")
public class MaterialController{

    private IMaterialService iMaterialService;

    @GetMapping
    public ResponseEntity<List<Material>> findAll() {
        return new ResponseEntity<>(iMaterialService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> findById(@PathVariable("id") int _id) {
        return new ResponseEntity<>(iMaterialService.findById(_id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Material> save(@RequestBody Material _material) {
        return new ResponseEntity<>(iMaterialService.save(_material), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> update(@PathVariable("id") int id, @RequestBody Material _material) {

        return new ResponseEntity<>(iMaterialService.update(_material), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int _id) {
        iMaterialService.delete(_id);
        return HttpStatus.OK;
    }
}
