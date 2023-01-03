package com.verlin.projectakhir.controller;

import com.verlin.projectakhir.entity.Spillbit;
import com.verlin.projectakhir.entity.User;
import com.verlin.projectakhir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/login/{username}/{password}")
    ResponseEntity<User> loginUser(@PathVariable("username") String username,
                                   @PathVariable("password") String password){
        return new ResponseEntity<>(userService.loginUser(username, password), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<User> sendUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.updateUser(user,id), HttpStatus.OK);
    }
}
