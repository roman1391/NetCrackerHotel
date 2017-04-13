package by.netcracker.hotel.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.HotelService;

@Controller
public class SearchHotelController {
    private final HotelService hotelService;

    @Autowired
    public SearchHotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "search-page", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        model.addAttribute("searchFilter", new SearchFilter());
        model.addAttribute("places", hotelService.getPlaces());
        return "search_page";
    }

    @RequestMapping(value = "find-hotels", method = RequestMethod.POST)
    public String findHotels(@ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
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
        return "search_page";
    }

}
