package com.javagain.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javagain.dao.UserDao;
import com.javagain.entity.Role;
import com.javagain.entity.User;
import com.javagain.service.UserService;

/**
 * User Service bean
 * 
 * @author Sandeep.Sharma
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User save(User user) {
		// Add selected roles
		List<Integer> roles = user.getRoles();
		List<Role> userRoles = new ArrayList<>(roles.size());
		// Set user roles into user object
		for (Integer id : roles) {
			userRoles.add(new Role(id));
		}
		user.setUserRoles(userRoles);
		return userDao.save(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean userExists(User user) {
		if (user == null) {
			throw new RuntimeException("User cannot be null");
		}
		User userdb = userDao.findByUsername(user.getUserName());
		if (userdb != null) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> list() {
		List<User> list = userDao.list();
		// Fetch each user roles
		if (list != null) {
			for (User user : list) {
				Hibernate.initialize(user.getUserRoles());
			}
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		User user = userDao.findByUsername(username);
		// Initialize user roles as it lazy load in user entity
		if (user != null) {
			Hibernate.initialize(user.getUserRoles());
		}
		return user;
	}

	@Override
	@Transactional
	public void delete(Long userId) {
		userDao.delete(userId);		
	}

}
