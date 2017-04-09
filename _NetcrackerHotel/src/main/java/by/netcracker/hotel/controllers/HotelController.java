package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.util.SampleDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "find-hotels", method = RequestMethod.POST)
    public String findHotels(@ModelAttribute("searchFilter") SearchFilter searchFilter, BindingResult bindingResult,
                             Model model) {
        String place = searchFilter.getPlace();
        List<String> places = new ArrayList<>(Arrays.asList(place.split(" ")));
        List<Hotel> hotels = hotelService.findHotels(places);
        model.addAttribute("hotels", hotels);
        model.addAttribute("places", SampleDataGenerator.createPlaces());
        return "search_page";
    }

}
