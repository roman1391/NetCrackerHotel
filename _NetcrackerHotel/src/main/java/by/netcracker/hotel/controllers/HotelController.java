package by.netcracker.hotel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.ReviewService;
import by.netcracker.hotel.services.RoomService;
import by.netcracker.hotel.utils.SearchFilter;

@Controller
@RequestMapping("/hotel_page")
@SessionAttributes("searchFilter")
public class HotelController {

    private WebApplicationContext context;
    private final HotelService hotelService;
    private final ReviewService reviewService;
    private final RoomService roomService;

    @Autowired
    public HotelController(WebApplicationContext context, HotelService hotelService, ReviewService reviewService,
        RoomService roomService) {
        this.context = context;
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
        model.addAttribute("review", context.getBean("review"));
        model.addAttribute("hotel_rooms", roomService.getFreeRoomsInHotelByDate(hotelID,
            searchFilter/* .getStartDate(), searchFilter.getEndDate() */));
        model.addAttribute("order", context.getBean("order"));
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
        model.addAttribute("review", context.getBean("review"));
        model.addAttribute("hotel_rooms", roomService.getByHotelID(hotelID));
        model.addAttribute("order", context.getBean("order"));
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
