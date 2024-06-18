package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
public class UserController {
	@Autowired
    private UserService userService;

	@PostMapping("/register/user")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) {
        try {
            userService.registerUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }
	
	@PostMapping("/login/user")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        if (user == null || user.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request. Please provide both username and password.");
        }
        
        boolean authenticated = userService.authenticateUser(user.getUserName(), user.getPassword());

        if (authenticated) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    
}
