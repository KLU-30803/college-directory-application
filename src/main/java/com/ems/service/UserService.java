package com.ems.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.entity.User;
import com.ems.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user); // Save user without encrypting password
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
