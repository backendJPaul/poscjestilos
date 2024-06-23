package com.jpaul.poscjestilos.model.controller;

import com.jpaul.poscjestilos.model.Cart;
import com.jpaul.poscjestilos.service.ICartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@AllArgsConstructor
@RestController
@RequestMapping("api/cart")
public class CartController{

    private ICartService iCartService;

    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        return new ResponseEntity<>(iCartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable("id") int _id) {
        return new ResponseEntity<>(iCartService.findById(_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> save(@RequestBody Cart _cart) {
        return new ResponseEntity<>(iCartService.save(_cart), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> update(@PathVariable("id") int id, @RequestBody Cart _cart) {
        return new ResponseEntity<>(iCartService.update(_cart), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int _id) {
        iCartService.delete(_id);
        return HttpStatus.OK;
    }
}
