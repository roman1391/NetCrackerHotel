package by.netcracker.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.entities.Hotel;

/**
 * Created by Varvara on 4/11/2017.
 */

@Controller
public class AddHotelController {

    @RequestMapping(value = "add-hotel", method = RequestMethod.POST)
    public String addHotel(@ModelAttribute("hotel") Hotel hotel, Model model) {
        return "add_hotel";
    }
}
