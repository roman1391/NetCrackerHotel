package by.netcracker.hotel.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.User;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {

		return new ModelAndView("home", "user", new User());
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User user, Model model) {

		model.addAttribute("user", user);
		return "main";
	}

}
