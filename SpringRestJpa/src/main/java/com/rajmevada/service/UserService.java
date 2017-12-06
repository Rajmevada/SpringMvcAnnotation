package com.rajmevada.service;

import java.util.List;

import com.rajmevada.model.User;

public interface UserService {

	List<User> getAllUser();
	
	User getUserById(String Id);
	
	void createUser(User u);
	
}
