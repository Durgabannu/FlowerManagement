package com.user.service;

import com.user.model.User;

public interface UserService {

	User findByUserName(String username);

	void saveUser(User user);

	boolean authenticateUser(String userName, String password);

	User registerUser(User user);

	

}
