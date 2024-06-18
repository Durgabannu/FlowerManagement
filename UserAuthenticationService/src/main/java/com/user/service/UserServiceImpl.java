package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    @Override
    public User registerUser(User user) {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    @Override
    public boolean authenticateUser(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
	
	
    
    
}
