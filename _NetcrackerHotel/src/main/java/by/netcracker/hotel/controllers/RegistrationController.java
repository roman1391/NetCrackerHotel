package by.netcracker.hotel.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.UserDAOImpl;
import by.netcracker.hotel.entities.User;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/reg-user", method = RequestMethod.POST)
	public ModelAndView checkUser(Locale locale, Model model) {
		return new ModelAndView("registration", "user", new User());
	}

	@RequestMapping(value = "/registered-user", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User user, Model model) {
		UserDAO userDao = new UserDAOImpl();
		userDao.regUser(user);
		return "main";
	}
}
