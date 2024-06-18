package com.payment.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.model.User;
@FeignClient(name = "UserAuthenticationService", url = "http://localhost:8081")

public interface UserClient {

	@PostMapping("/register/user")
    ResponseEntity<?> registerUser(@RequestBody User newUser);

    @PostMapping("/login/user")
    ResponseEntity<String> loginUser(@RequestBody User user);

    @GetMapping("/users/{userId}")
    User getUserById(@PathVariable("userId") Long userId);

}

