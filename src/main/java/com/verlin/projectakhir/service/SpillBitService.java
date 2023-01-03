package com.verlin.projectakhir.service;

import com.verlin.projectakhir.entity.Send;
import com.verlin.projectakhir.entity.Spillbit;
import com.verlin.projectakhir.repository.SpillBitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpillBitService {
    @Autowired
    private SpillBitRepository spillBitRepository;

    public List<Spillbit> getAllSpillbit(){
        return spillBitRepository.findAll();
    }

    public Spillbit getSpillbitById(Long id){
        return spillBitRepository.findById(id).get();
    }

    public Spillbit createSpillbit(Spillbit spillbit){
        return spillBitRepository.saveAndFlush(spillbit);
    }

    public Spillbit updateSpillbit(Spillbit spillbit, Long id){
        Optional<Spillbit> getSendById = spillBitRepository.findById(id);
        if (getSendById.isEmpty()){
            throw new RuntimeException();
        }
        return spillBitRepository.saveAndFlush(spillbit);
    }
}
