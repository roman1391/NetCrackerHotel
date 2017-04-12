package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.impl.UserServiceImpl;

/**
 * Created by slava КПСС on 07.04.17.
 */

@Controller
public class RegistrationController {

	private WebApplicationContext context;

	@Autowired
	public RegistrationController(WebApplicationContext context) {
		this.context = context;
	}

	@RequestMapping(value = "/register-user", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
		try {
			userService.registerUser(user);
		} catch (UsernameExistException e) {
			model.addAttribute("error", "Account with username - " + user.getUsername() + " are exist");
			return "registration";
		} catch (EmailExistException e) {
			model.addAttribute("error", "Account with email - " + user.getEmail() + " are exist");
			return "registration";
		}
		model.addAttribute("success", "You have successfully registered in system");
		return "successregistration";
	}
}
