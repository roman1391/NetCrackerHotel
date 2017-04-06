package by.netcracker.hotel.controllers;

import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.util.SampleDataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }

        model.setViewName("home");
        return model;
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

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "search-page", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        model.addAttribute("searchFilter", new SearchFilter());
        model.addAttribute("places", SampleDataGenerator.createPlaces());//TODO: add getting places from database (Varvara)
        return "search_page";
    }
}
