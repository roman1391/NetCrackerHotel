package by.netcracker.hotel.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;

@Controller
public class RegistrationController {

	@Autowired
	WebApplicationContext context;

	@RequestMapping(value = "/reg-user", method = RequestMethod.POST)
	public ModelAndView checkUser(Locale locale, Model model) {
		return new ModelAndView("registration", "user", new User());
	}

	@RequestMapping(value = "/registered-user", method = RequestMethod.POST)
	public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}

		// UserDAO userDao = new UserDAOImpl();

		// using spring jdbc
		UserDAO userDao = (UserDAO) context.getBean("UserDAOJdbcTemplateImpl");
		userDao.regUser(user);
		return "main";
	}
}
