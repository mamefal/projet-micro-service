package com.example.Auth_Service.controller;

import com.example.Auth_Service.entity.User;
import com.example.Auth_Service.jwt.JwtUtil;
import com.example.Auth_Service.repository.UserRepository;
import com.example.Auth_Service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/token")
    public String generateToken(@RequestBody User loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        if (userOptional.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), userOptional.get().getPassword())) {
            return jwtUtil.generateToken(loginRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode le mot de passe
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
