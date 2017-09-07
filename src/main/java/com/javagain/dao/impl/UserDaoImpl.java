package com.javagain.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javagain.dao.UserDao;
import com.javagain.entity.User;

/**
 * Implementation of UserDao's methods
 * 
 * @author Sandeep.Sharma
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String userName) {
		return (User) sessionFactory.getCurrentSession()
						.createQuery("from users where username=?")
						.setParameter(0, userName)
						.getSingleResult();
	}
	
	@Override
	public User save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}
}
