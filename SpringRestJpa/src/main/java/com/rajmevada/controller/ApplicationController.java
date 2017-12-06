package com.rajmevada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rajmevada.model.User;
import com.rajmevada.service.UserService;

@RestController
@RequestMapping("/")
public class ApplicationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = userService.getAllUser();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/user/{Id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable String Id) {

		User user = userService.getUserById(Id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<User> getUserById(@RequestBody User user) {
		System.out.println(user + "     "+user.getName());
		userService.createUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
