package com.example.demo.controller;

import com.example.demo.model.UserSpring;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{username}")
    public List<UserSpring> getUserByUsername(@PathVariable String username) {
        Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE username = '" + username + "'", UserSpring.class);
        return query.getResultList();
    }
}