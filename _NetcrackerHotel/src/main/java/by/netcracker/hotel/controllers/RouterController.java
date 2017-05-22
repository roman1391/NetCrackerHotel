package by.netcracker.hotel.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {

    private static Logger log = Logger.getLogger(RouterController.class);

    private WebApplicationContext context;

    @Autowired
    public RouterController(WebApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        model.addObject("error", error);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        return "profile";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            log.info("Invalid username or password while authentication");
            model.addAttribute("error", "Invalid username or password!");
        }
        return "login_page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", context.getBean("user"));
        return "registration";
    }

    @RequestMapping(value = "/leave_review", method = RequestMethod.GET)
    public String leaveReview() {
        return "leave_review";
    }

}
