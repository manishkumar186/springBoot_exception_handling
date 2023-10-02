package com.example.exception_test.controller;

import com.example.exception_test.entity.User;
import com.example.exception_test.exception.EmailAlreadyExists;
import com.example.exception_test.exception.UserNameAlreadyExists;
import com.example.exception_test.exception.UserNotFoundException;

import com.example.exception_test.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user) throws UserNameAlreadyExists, EmailAlreadyExists {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getALlUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
