package com.jpaul.poscjestilos.controller;

import com.jpaul.poscjestilos.model.ItemCart;
import com.jpaul.poscjestilos.service.IItemCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@AllArgsConstructor
@RequestMapping("api/itemcart")
public class ItemCartController {

    private IItemCartService iItemCartService;

    @GetMapping
    public ResponseEntity<List<ItemCart>> findAll() {
        return new ResponseEntity<>(iItemCartService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemCart> findById(@PathVariable("id") int _id) {
        return new ResponseEntity<>(iItemCartService.findById(_id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ItemCart> save(@RequestBody ItemCart itemCart) {
        return new ResponseEntity<>(iItemCartService.save(itemCart), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemCart> update(@PathVariable("id") int id, @RequestBody ItemCart itemCart) {
        return new ResponseEntity<>(iItemCartService.update(itemCart), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int _id) {
        iItemCartService.delete(_id);
        return HttpStatus.OK;
    }
}
