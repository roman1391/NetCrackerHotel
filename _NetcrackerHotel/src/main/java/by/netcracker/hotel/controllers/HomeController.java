package by.netcracker.hotel.controllers;

import by.netcracker.hotel.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import by.netcracker.hotel.exceptions.UserNotFoundException;
import by.netcracker.hotel.services.impl.UserServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private WebApplicationContext context;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}

		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User user, Model model) {

		UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
		try {
			userService.loginUser(user);
		} catch (UserNotFoundException e) {
			return "error";
		}
		return "successregistration";
	}

	@RequestMapping(value = "/user_page", method = RequestMethod.GET)
	public String mainPage() {

		return "user_page";
	}

	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public String adminPage() {

		return "admin_page";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {
		return "profile";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(UserDTO dto) {
		System.out.println(dto);
		return "true";
	}

}
