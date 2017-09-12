package com.javagain.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping(value = "/login")
public class LoginController {
	
	/**
	 * Show login page
	 * 
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String  login(@RequestParam(value = "error", required = false) String error,
			Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		return "login";
	}
}
