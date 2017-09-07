package com.javagain.dao;

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
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);

	/**
	 * Save user into database
	 * 
	 * @param user
	 * @return TODO
	 */
	User save(User user);

}
