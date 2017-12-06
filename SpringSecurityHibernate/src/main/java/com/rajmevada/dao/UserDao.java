package com.rajmevada.dao;

import com.rajmevada.model.User;

public interface UserDao {

	User findById(int id);

	User findBySSO(String sso);
}
