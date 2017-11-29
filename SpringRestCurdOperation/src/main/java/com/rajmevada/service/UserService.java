package com.rajmevada.service;

import java.util.List;

import com.rajmevada.model.User;

public interface UserService {

	User findById(int id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	List<User> findAllUsers();

	void deleteAllUsers();

	public boolean isUserExist(User user);
}
