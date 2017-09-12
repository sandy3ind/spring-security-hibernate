package com.javagain.dao;

import java.util.List;

import com.javagain.entity.User;

/**
 * User Dao interface to be used in service layer other part of application
 * 
 * @author Sandeep.Sharma
 *
 */
public interface UserDao {

	/**
	 * Fetch user by userName
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * Save user into database
	 * 
	 * @param user
	 * @return
	 */
	User save(User user);
	
	/**
	 * Return list of users
	 * 
	 * @return
	 */
	List<User> list();

}
