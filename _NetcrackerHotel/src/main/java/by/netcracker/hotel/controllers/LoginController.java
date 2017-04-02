package by.netcracker.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.services.impl.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User user, Model model) {

		UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
		userService.loginUser(user);

		return "successregistration";
	}

}
