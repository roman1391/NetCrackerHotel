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
import by.netcracker.hotel.services.impl.UserServiceImpl;

@Controller
public class RegistrationController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(value = "/registered-user", method = RequestMethod.POST)
	public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
		userService.registerUser(user);

		return "successregistration";
	}
}
