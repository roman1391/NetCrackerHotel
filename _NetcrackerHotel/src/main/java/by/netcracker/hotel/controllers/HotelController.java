package by.netcracker.hotel.controllers;

import java.util.List;

import javax.validation.Valid;

import by.netcracker.hotel.filter.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.ReviewService;
import by.netcracker.hotel.services.RoomService;

@Controller
@RequestMapping("/hotel_page")
@SessionAttributes("searchFilter")
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
    public String hotelPage(@Valid @PathVariable("id") int hotelID,
                            @ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        Hotel hotel = hotelService.getByID(hotelID);
        String reviewInfo = reviewService.checkReview(hotelID);
        model.addAttribute("reviewInfo", reviewInfo);
        model.addAttribute("choosenHotel", hotel);
        model.addAttribute("review", new Review());
        model.addAttribute("hotel_rooms", roomService.getFreeRoomsInHotelByDate(hotelID, searchFilter.getStartDate(), searchFilter.getEndDate()));
        model.addAttribute("order", new Order());
        return "hotel_page";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String hotelAfterReviewPage(@Valid @PathVariable("id") int hotelID,
        @Valid @ModelAttribute("review") Review review, Model model) {
        reviewService.addReview(review);
        Hotel hotel = hotelService.getByID(hotelID);
        String reviewInfo = reviewService.checkReview(hotelID);
        model.addAttribute("reviewInfo", reviewInfo);
        model.addAttribute("choosenHotel", hotel);
        model.addAttribute("review", new Review());
        model.addAttribute("hotel_rooms", roomService.getByHotelID(hotelID));
        model.addAttribute("order", new Order());
        model.addAttribute("success", "Thank you! The review will be added after approving by administrator");
        return "hotel_page";
    }

    @RequestMapping(value = "/review_page", method = RequestMethod.POST)
    public String feedbackPage(@Valid @ModelAttribute("choosenHotel") Hotel hotel,
        @Valid @ModelAttribute("review") Review review, Model model) {
        hotel = hotelService.getByID(hotel.getId());
        model.addAttribute("choosenHotel", hotel);
        return "review_page";
    }

    @RequestMapping(value = "/all_reviews", method = RequestMethod.POST)
    public String seeReviews(@Valid @ModelAttribute("choosenHotel") Hotel hotel, Model model) {
        List<Review> reviews = reviewService.getApprovedByHotelId(hotel.getId());
        model.addAttribute("currentReviews", reviews);
        return "hotel_reviews_page";
    }
}
