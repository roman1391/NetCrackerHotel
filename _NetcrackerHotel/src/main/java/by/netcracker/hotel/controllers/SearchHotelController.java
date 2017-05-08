package by.netcracker.hotel.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import by.netcracker.hotel.entities.Room;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.HotelService;

@Controller
@SessionAttributes("searchFilter")
public class SearchHotelController {
    private final HotelService hotelService;

    @Autowired
    public SearchHotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "/search-page", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        model.addAttribute("searchFilter", new SearchFilter());
        model.addAttribute("places", hotelService.getPlaces());
        return "search_page";
    }

    @RequestMapping(value = "/find-hotels", method = RequestMethod.POST)
    public String findHotels(@ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        String place = searchFilter.getPlace();
        List<String> places = hotelService.getPlaces();
        if (place != null) {
            List<String> chosenPlaces = new ArrayList<>(Arrays.asList(place.split("[,]")));
            Map<Hotel, List<Room>> hotels = hotelService.findHotels(chosenPlaces, searchFilter.getStartDate(),
                    searchFilter.getEndDate());
            if (hotels.isEmpty()) {
                model.addAttribute("message", "Nothing has been found. Please, try again!");
                hotels = null;
            }
            places.removeAll(chosenPlaces);
            model.addAttribute("hotels", hotels);
            model.addAttribute("choosenHotel", new Hotel());
            model.addAttribute("search", chosenPlaces);
            //model.addAttribute("searchFilter", searchFilter);
        } else {
            model.addAttribute("message", "Please, enter place for search!");
        }
        model.addAttribute("places", places);
        return "search_page";
    }

    @RequestMapping(value = "/hotel_discription_ajax", method = RequestMethod.GET)
    public @ResponseBody List<String> ajaxHotelDiscription(){

        return hotelService.getPlaces();
    }

}
