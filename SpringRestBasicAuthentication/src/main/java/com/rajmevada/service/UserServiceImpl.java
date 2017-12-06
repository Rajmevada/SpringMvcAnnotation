package com.rajmevada.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.rajmevada.model.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	private static final AtomicInteger counter = new AtomicInteger();
	private static List<User> users;

	static {
		users = dummyUsers();
	}

	@Override
	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for (User user : users) {
			if (user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void updateUser(User user) {
		int index=users.indexOf(user);
		users.set(index, user);
	}

	@Override
	public void deleteUserById(long id) {
		Iterator<User> iterator=users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if(user.getId()==id){
				iterator.remove();
				System.out.println("deleted");
			}
		}
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("all are "+users);
		return users;
	}

	@Override
	public void deleteAllUsers() {
		users.clear();

	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return findByName(user.getName())!=null;
	}

	private static List<User> dummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "Raj", "Godhra"));
		users.add(new User(counter.incrementAndGet(), "Anuj", "Godhra"));
		users.add(new User(counter.incrementAndGet(), "Ali", "Godhra"));
		users.add(new User(counter.incrementAndGet(), "Chinmay", "Godhra"));
		return users;
	}

}
