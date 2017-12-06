package com.rajmevada.service;

import com.rajmevada.model.User;

public interface UserService {

	User findById(int id);
    
    User findBySso(String sso);
}
