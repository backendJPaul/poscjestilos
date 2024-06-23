package com.jpaul.poscjestilos.model.controller;


import com.jpaul.poscjestilos.model.Color;
import com.jpaul.poscjestilos.service.IColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("api/color")
@AllArgsConstructor
public class ColorController{

    private IColorService iColorService;


    @GetMapping
    public ResponseEntity<List<Color>> findAll() {
        List<Color> colorList = iColorService.findAll();
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(iColorService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Color> save(@RequestBody Color _color) {
        return new ResponseEntity<>(iColorService.save(_color), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> update(@PathVariable("id") int id, @RequestBody Color _color) {
        return new ResponseEntity<>(iColorService.update(_color), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable int id) {
        iColorService.delete(id);
        return HttpStatus.OK;
    }
}
