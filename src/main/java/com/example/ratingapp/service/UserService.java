package com.example.ratingapp.service;

import com.example.ratingapp.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User findById(String id);

    List<User> getUsersList();

    void deleteUserById(String id);

    void updateUser(User userForm);

    List<User> findByFillFields(User user);

}
