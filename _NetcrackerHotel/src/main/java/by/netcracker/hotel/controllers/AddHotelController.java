package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Hotel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static by.netcracker.hotel.util.ModelUtil.createModel;

/**
 * Created by Varvara on 4/11/2017.
 */

@Controller
public class AddHotelController {

    @RequestMapping(value = "add-hotel", method = RequestMethod.POST)
    public ModelAndView addHotel(@ModelAttribute("hotel") Hotel hotel, BindingResult bindingResult,
                                 Model model, Authentication authentication) {
        return createModel("add_hotel", authentication);
    }

}
