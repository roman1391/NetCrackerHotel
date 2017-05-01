package by.netcracker.hotel.controllers;

import java.util.List;

import javax.validation.Valid;

import by.netcracker.hotel.entities.*;
import by.netcracker.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.ReviewService;

@Controller
@RequestMapping("/hotel_page")
public class HotelController {
    private final HotelService hotelService;
    private final ReviewService reviewService;
    private final RoomService roomService;

    @Autowired
    public HotelController(HotelService hotelService, ReviewService reviewService, RoomService roomService) {
        this.hotelService = hotelService;
        this.reviewService = reviewService;
        this.roomService = roomService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String hotelPage(@Valid @PathVariable("id") int hotelID, Model model) {
        Hotel hotel = hotelService.getByID(hotelID);
        String reviewInfo = reviewService.checkReview(hotelID);
        model.addAttribute("reviewInfo", reviewInfo);
        model.addAttribute("choosenHotel", hotel);
        model.addAttribute("review", new Review());
        model.addAttribute("hotel_rooms", roomService.getByHotelID(hotelID));
        model.addAttribute("order", new Order());
        return "hotel_page";
    }

    @RequestMapping(value = "/review_page", method = RequestMethod.POST)
    public String feedbackPage(@Valid @ModelAttribute("choosenHotel") Hotel hotel,
        @Valid @ModelAttribute("review") Review review, Model model) {
        hotel = hotelService.getByID(hotel.getId());
        model.addAttribute("choosenHotel", hotel);
        return "review_page";
    }

    @RequestMapping(value = "/send_review", method = RequestMethod.POST)
    public String sendFeenback(@Valid @ModelAttribute("choosenHotel") Hotel hotel,
        @Valid @ModelAttribute("review") Review review, Model model) {
        reviewService.addReview(review);
        hotel = hotelService.getByID(review.getHotelId());
        model.addAttribute("choosenHotel", hotel);
        model.addAttribute("success", "Thank you for review");
        return "hotel_page";
    }

    @RequestMapping(value = "/list_of_reviews", method = RequestMethod.POST)
    public String seeReviews(@Valid @ModelAttribute("choosenHotel") Hotel hotel, Model model) {
        List<Review> list = reviewService.getByHotelId(hotel.getId());
        model.addAttribute("currentReviews", list);
        return "hotel_reviews_page";
    }
}
