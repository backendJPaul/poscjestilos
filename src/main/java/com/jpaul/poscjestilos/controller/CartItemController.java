package com.jpaul.poscjestilos.controller;

import com.jpaul.poscjestilos.model.CartItem;
import com.jpaul.poscjestilos.service.ICartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@AllArgsConstructor
@RequestMapping("api/cartitem")
public class CartItemController{

    private ICartItemService iCartItemService;

    @GetMapping
    public ResponseEntity<List<CartItem>> findAll() {
        return new ResponseEntity<>(iCartItemService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CartItem> findById(@PathVariable("id") int _id) {
        return new ResponseEntity<>(iCartItemService.findById(_id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CartItem> save(@RequestBody CartItem cartItem) {
        return new ResponseEntity<>(iCartItemService.save(cartItem), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CartItem> update(@PathVariable("id") int id, @RequestBody CartItem cartItem) {
        return new ResponseEntity<>(iCartItemService.update(cartItem), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int _id) {
        iCartItemService.delete(_id);
        return HttpStatus.OK;
    }
}
