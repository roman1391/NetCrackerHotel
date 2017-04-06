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

import java.util.List;

/**
 * @author Yauheni Shopik
 * @since 4/7/2017
 */
@Controller
public class HotelController {

    @RequestMapping(value = "find-hotels", method = RequestMethod.POST)
    public String findHotels(@ModelAttribute("searchFilter") SearchFilter searchFilter, BindingResult bindingResult,
                             Model model) {
        List<Hotel> hotels = SampleDataGenerator.createHotelList(); //TODO: add getting hotels from database (Varvara)
        model.addAttribute("hotels", hotels);
        model.addAttribute("places", SampleDataGenerator.createPlaces());
        return "search_page";
    }

}
