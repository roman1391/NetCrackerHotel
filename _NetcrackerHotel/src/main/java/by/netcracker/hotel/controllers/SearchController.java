package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.util.SampleDataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Varvara on 3/31/2017.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getSearchPage() {
        return new ModelAndView("search", "searchFilter", new SearchFilter());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String findHotels(@ModelAttribute("searchFilter") SearchFilter searchFilter, BindingResult bindingResult,
                             Model model) {
        List<Hotel> hotels = SampleDataGenerator.createHotelList(); //TODO: add getting hotels from database
        model.addAttribute("hotels", hotels);
        return "search";
    }
}
