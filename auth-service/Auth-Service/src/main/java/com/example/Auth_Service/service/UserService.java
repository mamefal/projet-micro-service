package com.example.Auth_Service.service;

import com.example.Auth_Service.entity.User;
import com.example.Auth_Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
