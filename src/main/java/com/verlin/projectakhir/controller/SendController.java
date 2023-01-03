package com.verlin.projectakhir.controller;

import com.verlin.projectakhir.entity.Send;
import com.verlin.projectakhir.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/send")
public class SendController {
    @Autowired
    private SendService sendService;

    @GetMapping
    ResponseEntity<List<Send>> getAllSend(){
        return new ResponseEntity<>(sendService.getAllSend(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Send> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(sendService.getSendById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Send> sendUser(@RequestBody Send send){
        return new ResponseEntity<>(sendService.createSend(send), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Send> updateUser(@RequestBody Send send, @PathVariable("id") Long id){
        return new ResponseEntity<>(sendService.updateSend(send,id), HttpStatus.OK);
    }
}
