package by.netcracker.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.User;

@Controller
public class RouterController {

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        model.addObject("error", error);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/admin/admin_page", method = RequestMethod.GET)
    public String adminPage() {
        return "admin/admin_page";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        model.addAttribute("activeUser", new User());
        return "profile";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password!");
        }
        return "login_page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/leave_review", method = RequestMethod.GET)
    public String leaveReview() {
        return "leave_review";
    }
}
