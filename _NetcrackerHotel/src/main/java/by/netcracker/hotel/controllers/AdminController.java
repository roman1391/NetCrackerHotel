package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static by.netcracker.hotel.util.ModelUtil.createModel;

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

	@RequestMapping(value = "/add_hotel", method = RequestMethod.GET)
	public ModelAndView about(Model model, Authentication authentication)
    {
        model.addAttribute("hotel", new Hotel());
		return createModel("add_hotel", authentication);
	}

}
