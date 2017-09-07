package com.javagain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		// Check if user is already exists
		
		// Save user
		userService.save(user);
		
		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");        
		
		return "registrationSuccess";
	}
}
