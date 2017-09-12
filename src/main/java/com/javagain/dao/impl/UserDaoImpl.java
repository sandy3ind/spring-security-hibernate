package com.javagain.dao.impl;

import java.util.List;

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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String username) {
		//When you don't know whether there are any results, use getResultList()		
		List<User> users = (List<User>) sessionFactory.getCurrentSession()
						.createQuery("from User where userName=?")
						.setParameter(0, username)
						.getResultList();
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	public User save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return (List<User>) sessionFactory.getCurrentSession()
				.createQuery("from User")
				.list();
	}
}
