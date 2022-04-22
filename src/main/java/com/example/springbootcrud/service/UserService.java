package com.example.springbootcrud.service;

import com.example.springbootcrud.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    User saveUser(User user);
    void deleteById(Long id);
}
