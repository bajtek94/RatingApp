package com.example.ratingapp.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
