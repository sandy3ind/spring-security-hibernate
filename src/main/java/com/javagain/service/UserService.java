package com.javagain.service;

import java.util.List;

import com.javagain.entity.User;

/**
 * User service to perform user specific operations
 * 
 * @author Sandeep.Sharma
 *
 */
public interface UserService {
	/**
	 * Save user int database
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user);

	/**
	 * Check if user already exists in the database
	 * 
	 * @param user
	 * @return
	 */
	boolean userExists(User user);
	
	/**
	 * Return list of users
	 * 
	 * @return
	 */
	List<User> list();
	
	/**
	 * Load user by username
	 * 
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	
}
