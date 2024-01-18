package com.ms.user.service;

import com.ms.user.model.User;
import com.ms.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    UserRepository userRepository;

    public User create(User user){
        return this.userRepository.save(user);
    }

    public List<User> getAll(){
        return (List<User>) this.userRepository.findAll();
    }
}
