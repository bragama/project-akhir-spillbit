package com.verlin.projectakhir.service;

import com.verlin.projectakhir.entity.Request;
import com.verlin.projectakhir.entity.Send;
import com.verlin.projectakhir.repository.SendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SendService {
    @Autowired
    private SendRepository sendRepository;

    public List<Send> getAllSend(){
        return sendRepository.findAll();
    }

    public Send getSendById(Long id){
        return sendRepository.findById(id).get();
    }

    public Send createSend(Send send){
        return sendRepository.saveAndFlush(send);
    }

    public Send updateSend(Send send, Long id){
        Optional<Send> getSendById = sendRepository.findById(id);
        if (getSendById.isEmpty()){
            throw new RuntimeException();
        }
        return sendRepository.saveAndFlush(send);
    }
}
