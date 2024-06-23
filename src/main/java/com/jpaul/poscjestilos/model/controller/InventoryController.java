package com.jpaul.poscjestilos.model.controller;

import com.jpaul.poscjestilos.model.Inventory;
import com.jpaul.poscjestilos.service.IInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("api/inventory")
@AllArgsConstructor
public class InventoryController{

    private IInventoryService iInventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> findAll() {
        return new ResponseEntity<>(iInventoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> findById(@PathVariable("id") Integer _id) {
        return new ResponseEntity<>(iInventoryService.findById(_id), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Inventory> save(@RequestBody Inventory inventory) {
        return new ResponseEntity<>(iInventoryService.save(inventory), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(@PathVariable("id") Integer id, @RequestBody Inventory inventory) {
        return new ResponseEntity<>(iInventoryService.update(inventory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Integer _id) {
        iInventoryService.delete(_id);
        return HttpStatus.OK;
    }
}
