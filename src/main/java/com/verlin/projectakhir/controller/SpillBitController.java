package com.verlin.projectakhir.controller;

import com.verlin.projectakhir.entity.Request;
import com.verlin.projectakhir.entity.Spillbit;
import com.verlin.projectakhir.service.SpillBitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spill-bit")
public class SpillBitController {
    @Autowired
    private SpillBitService spillBitService;
    @GetMapping
    ResponseEntity<List<Spillbit>> getAllSpillbit(){
        return new ResponseEntity<>(spillBitService.getAllSpillbit(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Spillbit> getSpillbitById(@PathVariable("id") Long id){
        return new ResponseEntity<>(spillBitService.getSpillbitById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Spillbit> sendSpillbit(@RequestBody Spillbit spillbit){
        return new ResponseEntity<>(spillBitService.createSpillbit(spillbit), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Spillbit> updateSpillbit(@RequestBody Spillbit spillbit, @PathVariable("id") Long id){
        return new ResponseEntity<>(spillBitService.updateSpillbit(spillbit,id), HttpStatus.OK);
    }

}
