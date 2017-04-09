package by.netcracker.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.services.UserService;

@Controller
public class AdminController {
	private final UserService userService;

	@Autowired
	public AdminController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/list_of_users", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAll());
		return "list_of_users";

	}
}
