package com.jpaul.poscjestilos.controller;


import com.jpaul.poscjestilos.model.Sale;
import com.jpaul.poscjestilos.service.ISaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/sale")
public class SaleController{

    private ISaleService iSaleService;

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        return new ResponseEntity<>(iSaleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Integer id, Integer _id) {
        return new ResponseEntity<>(iSaleService.findById(_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody Sale sale) {
        return new ResponseEntity<>(iSaleService.save(sale), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(Sale sale) {
        return new ResponseEntity<>(iSaleService.update(sale), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(Integer _id) {
        iSaleService.delete(_id);
        return HttpStatus.OK;
    }
}
