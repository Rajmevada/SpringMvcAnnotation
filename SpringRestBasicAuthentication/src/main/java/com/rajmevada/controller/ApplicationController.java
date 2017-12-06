package com.rajmevada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.rajmevada.model.User;
import com.rajmevada.service.UserService;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@Autowired
	UserService service;

	/**
	 * All-Users
	 * 
	 * @return List<User>
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		System.out.println("get method");
		List<User> userList = service.findAllUsers();
		if (userList.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		System.out.println(id);
		User user = service.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {

		if (service.isUserExist(user)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		service.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ResponseEntity<User> listAll2Users() {
		User user=new User(10, "Raj", "Bombay");
		service.saveUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
