package by.netcracker.hotel.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.services.ReviewService;
import by.netcracker.hotel.services.UserService;

@Service("ReviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDAO reviewDAO;
    private UserService userService;

    @Autowired
    public ReviewServiceImpl(ReviewDAO reviewDAO, UserService userService) {
        this.reviewDAO = reviewDAO;
        this.userService = userService;
    }

    @Override
    public Review getByID(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addReview(Review review) {
        review.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        review.setStatus("pending");
        reviewDAO.add(review);
    }

    @Override
    public String checkReview(int hotelId) {
        String reviewInfo;
        Object info = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (info instanceof String) {
            reviewInfo = "forbidden";
        } else if (info instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) info;
            User user = (User) userService.getUserByUsername(userDetails.getUsername());
            if (user.getAuthority().equals(ROLE.ADMIN)) {
                reviewInfo = "moderate";
            } else {
                reviewInfo = reviewDAO.checkUsersReview(hotelId, user.getId());
            }
        } else {
            reviewInfo = "no";
        }
        return reviewInfo;
    }

}
