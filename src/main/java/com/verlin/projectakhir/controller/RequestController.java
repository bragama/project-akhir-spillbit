package com.verlin.projectakhir.controller;

import com.verlin.projectakhir.entity.Request;
import com.verlin.projectakhir.entity.Send;
import com.verlin.projectakhir.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping
    ResponseEntity<List<Request>> getAllRequest(){
        return new ResponseEntity<>(requestService.getAllRequest(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Request> getRequestById(@PathVariable("id") Long id){
        return new ResponseEntity<>(requestService.getRequestById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Request> sendUser(@RequestBody Request request){
        return new ResponseEntity<>(requestService.createRequest(request), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Request> updateUser(@RequestBody Request request, @PathVariable("id") Long id){
        return new ResponseEntity<>(requestService.updateRequest(request,id), HttpStatus.OK);
    }
}
