package com.example.ratingapp.service;

import com.example.ratingapp.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> getUsersList();

    void deleteUserById(String id);

}
