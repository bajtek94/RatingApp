package com.example.ratingapp.service;

import com.example.ratingapp.model.Role;
import com.example.ratingapp.model.User;
import com.example.ratingapp.repository.RoleRepository;
import com.example.ratingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findOne(1L));
        user.setRoles(roles);
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
        if(user.getUsername() == "" && user.getEmail() == "" && user.getName() == "" && user.getLastName() == "") {
            return new ArrayList<>();
        }
        ///////////// 1 pole wypełnione
        else if(user.getUsername() == "" && user.getEmail() == "" && user.getName() == "") {
            return userRepository.findByLastName(user.getLastName());
        }
        else if(user.getUsername() == "" && user.getEmail() == "" && user.getLastName() == "") {
            return userRepository.findByName(user.getName());
        }
        else if(user.getUsername() == "" && user.getLastName() == "" && user.getName() == "") {
            return userRepository.findByEmail(user.getEmail());
        }
        else if(user.getLastName() == "" && user.getEmail() == "" && user.getName() == "") {
            return userRepository.findListByUsername(user.getUsername());
        }
        ///////////// 2 pola wypełnione
        else if(user.getUsername() == "" && user.getEmail() == "") {
            return userRepository.findByNameAndLastName(user.getName(), user.getLastName());
        }
        else if(user.getUsername() == "" && user.getName() == "") {
            return userRepository.findByEmailAndLastName(user.getEmail(), user.getLastName());
        }
        else if(user.getUsername() == "" && user.getLastName() == "") {
            return userRepository.findByEmailAndName(user.getEmail(), user.getName());
        }
        else if(user.getEmail() == "" && user.getName() == "") {
            return userRepository.findByUsernameAndLastName(user.getUsername(), user.getLastName());
        }
        else if(user.getEmail() == "" && user.getLastName() == "") {
            return userRepository.findByUsernameAndName(user.getUsername(), user.getName());
        }
        else if(user.getName() == "" && user.getLastName() == "") {
            return userRepository.findByUsernameAndEmail(user.getUsername(), user.getEmail());
        }
        ///////////// 3 pola wypełnione
        else if(user.getUsername() == "") {
            return userRepository.findByEmailNameAndLastName(user.getEmail(), user.getName(), user.getLastName());
        }
        else if(user.getEmail() == "") {
            return userRepository.findByUsernameNameAndLastName(user.getUsername(), user.getName(), user.getLastName());
        }
        else if(user.getName() == "") {
            return userRepository.findByUsernameEmailAndLastName(user.getUsername(), user.getEmail(), user.getLastName());
        }
        else if(user.getLastName() == "") {
            return userRepository.findByUsernameEmailAndName(user.getUsername(), user.getEmail(), user.getName());
        }
        ///////////// 4 pola wypełnione
        else {
            return userRepository.findByEverything(user.getUsername(), user.getEmail(), user.getName(), user.getLastName());
        }


    }
}
