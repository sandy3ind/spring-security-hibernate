package com.javagain.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javagain.entity.User;
import com.javagain.service.UserService;

/**
 * 
 * @author Sandeep.Sharma
 *
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new SecurityUser(user);
	}

}
