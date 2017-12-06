package com.rajmevada.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajmevada.model.User;

@Service
public interface UserDao {
	
	List<User> getAllUsers();
	
	User getById(String Id);
	
	void createUser(User u);
}
