package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.netcracker.hotel.util.ModelUtil.createModel;

@Controller
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "search-page", method = RequestMethod.GET)
    public ModelAndView getSearchPage(Model model, Authentication authentication) {
        model.addAttribute("searchFilter", new SearchFilter());
        model.addAttribute("places", hotelService.getPlaces());
        return createModel("search_page", authentication);
    }

    @RequestMapping(value = "find-hotels", method = RequestMethod.POST)
    public ModelAndView findHotels(@ModelAttribute("searchFilter") SearchFilter searchFilter, BindingResult bindingResult,
                                   Model model, Authentication authentication) {
        String place = searchFilter.getPlace();
        model.addAttribute("places", hotelService.getPlaces());
        if (place != null) {
            List<String> places = new ArrayList<>(Arrays.asList(place.split("[, ]")));
            List<Hotel> hotels = hotelService.findHotels(places);
            if (hotels.isEmpty()) {
                model.addAttribute("message", "Nothing has been found. Please, try again!");
                hotels = null;
            }
            model.addAttribute("hotels", hotels);
        } else {
            model.addAttribute("message", "Please, enter place for search!");
        }
        return createModel("search_page", authentication);
    }

}
