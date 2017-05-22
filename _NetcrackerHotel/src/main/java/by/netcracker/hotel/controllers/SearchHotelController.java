package by.netcracker.hotel.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.utils.SearchFilter;

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
            Map<Hotel, List<Room>> hotels = hotelService.findHotels(chosenPlaces, searchFilter);
            if (hotels.isEmpty()) {
                model.addAttribute("message", "Nothing has been found. Please, try again!");
                hotels = null;
            }
            places.removeAll(chosenPlaces);
            model.addAttribute("hotels", hotels);
            model.addAttribute("choosenHotel", new Hotel());
            model.addAttribute("search", chosenPlaces);
            // model.addAttribute("searchFilter", searchFilter);
        } else {
            model.addAttribute("message", "Please, enter place for search!");
        }
        model.addAttribute("places", places);
        return "search_page";
    }

    @RequestMapping(value = "/hotel_discription_ajax", method = RequestMethod.GET)
    public @ResponseBody List<String> ajaxHotelDiscription() {

        return hotelService.getPlaces();
    }

}
