package com.order.feignClient;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserAuthenticationService", url = "http://localhost:8081")

public interface UserAuthFeignClient {
	@PostMapping("/register/user")
    ResponseEntity<?> registerUser(@RequestBody User newUser);

    @PostMapping("/login/user")
    ResponseEntity<String> loginUser(@RequestBody User user);
}
