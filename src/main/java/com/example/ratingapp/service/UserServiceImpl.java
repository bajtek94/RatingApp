package com.example.ratingapp.service;

import com.example.ratingapp.model.User;
import com.example.ratingapp.repository.RoleRepository;
import com.example.ratingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(String id) {
        User user = userRepository.findOne(Long.parseLong(id));
        if(user != null) {
            userRepository.delete(user.getId());
        }
    }

    @Override
    public User findById(String id) {
        return userRepository.findOne(Long.parseLong(id));
    }

    @Override
    public void updateUser(User user) {
        User userTmp = userRepository.findOne(user.getId());
        if(userTmp != null) {
            userTmp.setUsername(user.getUsername());
            userTmp.setEmail(user.getEmail());
            userTmp.setName(user.getName());
            userTmp.setLastName(user.getLastName());
        }
        userRepository.save(userTmp);
    }

    @Override
    public List<User> findByFillFields(User user) {
//        System.out.println("TEST: " + user.getUsername() + ", " + user.getEmail());
        return userRepository.findByUsernameAndMail(user.getUsername(), user.getEmail());
    }
}
