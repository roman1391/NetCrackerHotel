package by.netcracker.hotel.controllers;

import by.netcracker.hotel.filter.SearchFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Varvara on 3/31/2017.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getSearchPage(){
        return new ModelAndView("search", "searchFilter", new SearchFilter());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView findHotels(@ModelAttribute("searchFilter")SearchFilter searchFilter, BindingResult bindingResult){
        return new ModelAndView("search");
    }


}
