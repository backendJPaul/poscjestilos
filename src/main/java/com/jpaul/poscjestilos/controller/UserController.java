package com.jpaul.poscjestilos.controller;

import com.jpaul.poscjestilos.model.User;
import com.jpaul.poscjestilos.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController{

    private IUserService iUserService;
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(iUserService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int _id) {
        return new ResponseEntity<>(iUserService.findById(_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User _user) {
        return new ResponseEntity<>(iUserService.save(_user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") int _id, @RequestBody User _user) {
        return iUserService.update(_user);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable int id) {
        iUserService.delete(id);
        return HttpStatus.OK;

    }
}
