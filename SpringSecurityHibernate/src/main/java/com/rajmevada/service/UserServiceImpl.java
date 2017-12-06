package com.rajmevada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajmevada.dao.UserDao;
import com.rajmevada.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findBySso(String sso) {
		// TODO Auto-generated method stub
		return dao.findBySSO(sso);
	}

}
