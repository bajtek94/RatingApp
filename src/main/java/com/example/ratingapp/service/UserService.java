package com.example.ratingapp.service;

import com.example.ratingapp.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
