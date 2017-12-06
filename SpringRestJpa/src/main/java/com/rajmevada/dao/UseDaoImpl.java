package com.rajmevada.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rajmevada.model.User;

@Repository("userDao")
public class UseDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public List<User> getAllUsers() {
		return (List<User>) getEntityManager().createQuery("Select u from User u").getResultList();
	}

	@Override
	public User getById(String Id) {
		return (User) getEntityManager().createQuery("select u from User u where id = :id")
				.setParameter("id", Integer.parseInt(Id)).getSingleResult();
	}

	@Override
	public void createUser(User u) {
		getEntityManager().persist(u);
	}

}
