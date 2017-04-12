package by.netcracker.hotel.controllers;

import static by.netcracker.hotel.util.ModelUtil.createModel;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.User;
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
		model.addAttribute("user", new User());
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// System.out.println(userDetails.getUsername());
		// System.out.println(userDetails.getPassword());
		// String auth =
		// Arrays.asList(userDetails.getAuthorities().toArray()).get(0).toString();
		// System.out.println(auth);
		return "list_of_users";
	}

	@RequestMapping(value = "/edit_form", method = RequestMethod.POST)
	public String getEditForms(@Valid @ModelAttribute("user") User user, Model model) {
		user = (User) userService.getUserByUsername(user.getUsername());
		model.addAttribute("user", user);
		return "user_editing";
	}

	@RequestMapping(value = "/block_user", method = RequestMethod.POST)
	public String blockUser(@Valid @ModelAttribute("user") User user, Model model) {
		userService.blockUser(user);
		model.addAttribute("users", userService.getAll());
		model.addAttribute("user", new User());
		return "list_of_users";
	}

	@RequestMapping(value = "/add_hotel", method = RequestMethod.GET)
	public ModelAndView about(Model model, Authentication authentication) {
		model.addAttribute("hotel", new Hotel());
		return createModel("add_hotel", authentication);
	}

}
