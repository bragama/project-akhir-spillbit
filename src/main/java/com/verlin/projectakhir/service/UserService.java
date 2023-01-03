package com.verlin.projectakhir.service;

import com.verlin.projectakhir.entity.Spillbit;
import com.verlin.projectakhir.entity.User;
import com.verlin.projectakhir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User createUser(User user){
        List<User> users = getAllUser();
        users.forEach(e ->{
            if (Objects.equals(e.getEmail(), user.getEmail()) || Objects.equals(e.getUsername(), user.getUsername())){
                throw new RuntimeException();
            }
        });
        return userRepository.saveAndFlush(user);
    }

    public User loginUser(String username, String password){
        return userRepository.getUserByLogin(username,password);
    }

    public User updateUser(User user, Long id){
        Optional<User> getSendById = userRepository.findById(id);
        if (getSendById.isEmpty()){
            throw new RuntimeException();
        }
        return userRepository.saveAndFlush(user);
    }
}
