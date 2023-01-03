package com.verlin.projectakhir.service;

import com.verlin.projectakhir.entity.Request;
import com.verlin.projectakhir.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllRequest(){
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id){
        return requestRepository.findById(id).get();
    }

    public Request createRequest(Request request){
        return requestRepository.saveAndFlush(request);
    }

    public Request updateRequest(Request request, Long id){
        Optional<Request> getRequestById = requestRepository.findById(id);
        if (getRequestById.isEmpty()){
            throw new RuntimeException();
        }
        return requestRepository.saveAndFlush(request);
    }
}
