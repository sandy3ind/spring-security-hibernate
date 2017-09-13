package com.javagain.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javagain.config.security.SecurityUser;
import com.javagain.entity.Role;
import com.javagain.entity.User;
import com.javagain.service.UserService;

/**
 * This is User Controller to interact with view layer and controlling request flow
 *  
 * @author Sandeep.Sharma
 *
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * Show Registration form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        
        List<Role> roles = new ArrayList<>(3);
        roles.add(new Role(1, "USER"));
        roles.add(new Role(2, "ADMIN"));
        roles.add(new Role(3, "DBA"));        
        model.addAttribute("roles", roles);
        
        return "registration";
    }
	
	/**
	 * Save new User
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String  save(@Valid User user, BindingResult result, Model model) {		
		// Redirect to registration page if there is any error
		if (result.hasErrors()) {
            return "registration";
        }
		
		// Check if user already exists
		if (userService.userExists(user)) {
			model.addAttribute("error", "User " + user.getFirstName() + " "+ user.getLastName() + " already exists in our record!");
			return "registration";
		}
		
		// Save user		
		userService.save(user);
		
		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");        
		
		return "registrationSuccess";
	}
	
	/**
	 * Show list of users
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
		// Get user list from database
		List<User> list = userService.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	/**
	 * Delete user and its roles
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") Long userId) {
		userService.delete(userId);
		return "redirect:/users/list";
	}
	
	/**
	 * Show home page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {			
		model.addAttribute("user", SecurityUser.getUser());
		return "home";
	}
	
	/**
	 * Show Admin page
	 * 
	 * @return
	 */
	@RequestMapping(value = "admin", method = RequestMethod.GET)
    public String admin() {		
		return "admin";
	}
	
	/**
	 * Show User page
	 * 
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
    public String user() {
		return "user";
	}
	
	/**
	 * Show DBA page
	 * @return
	 */
	@RequestMapping(value = "dba", method = RequestMethod.GET)
    public String dba() {		
		return "dba";
	}
	
	
}
