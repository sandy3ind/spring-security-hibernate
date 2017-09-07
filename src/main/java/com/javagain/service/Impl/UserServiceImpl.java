package com.javagain.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javagain.dao.UserDao;
import com.javagain.entity.User;
import com.javagain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User save(User user) {
		return userDao.save(user);
	}

}
