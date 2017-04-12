package by.netcracker.hotel.controllers;

import static by.netcracker.hotel.util.ModelUtil.createModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.services.UserService;

@Controller
public class RouterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value = "error", required = false) String error,
			Authentication authentication) {
		ModelAndView model = createModel("home", authentication);
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}
		return model;
	}

	@RequestMapping(value = "/user_page", method = RequestMethod.GET)
	public ModelAndView mainPage(Authentication authentication) {
		return createModel("user_page", authentication);
	}

	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public ModelAndView adminPage(Authentication authentication) {
		return createModel("admin_page", authentication);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(Authentication authentication) {
		ModelAndView model = createModel("profile", authentication);
		String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal())
				.getUsername();
		// TODO CONVERT ALL ENTITIES TO
		// DTO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		model.addObject("user", userService.getUserByUsername(username));
		return model;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(Authentication authentication) {
		return createModel("about", authentication);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			Authentication authentication) {
		ModelAndView model = createModel("login_page", authentication);
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}
		return model;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(Model model, Authentication authentication) {
		model.addAttribute("user", new User());
		return createModel("registration", authentication);
	}

	@RequestMapping(value = "/leave_review", method = RequestMethod.GET)
	public String leaveReview() {
		return "leave_review";
	}
}
