package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.entities.Feedback;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.services.HotelService;

@Controller
public class FeedbackController {
    private final HotelService hotelService;

    @Autowired
    public FeedbackController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "/feedback_page", method = RequestMethod.POST)
    public String feedbackPage(@Valid @ModelAttribute("choosenHotel") Hotel hotel,
        @Valid @ModelAttribute("feedback") Feedback feedback, Model model) {
        hotel = hotelService.getByID(hotel.getId());
        model.addAttribute("choosenHotel", hotel);
        return "feedback_page";
    }

    @RequestMapping(value = "/send_feedback", method = RequestMethod.POST)
    public String sendFeenback(@Valid @ModelAttribute("choosenHotel") Hotel hotel,
        @Valid @ModelAttribute("feedback") Feedback feedback, Model model) {
        System.out.println(feedback);
        hotel = hotelService.getByID(feedback.getHotelId());
        System.out.println(hotel.getName());
        model.addAttribute("choosenHotel", hotel);
        model.addAttribute("success", "Thank you for feedback");
        return "hotel_page";
    }

}
