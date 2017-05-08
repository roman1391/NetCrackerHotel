package by.netcracker.hotel.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.services.ReviewService;
import by.netcracker.hotel.services.UserService;

@Service("ReviewServiceImpl")
@SessionScope
public class ReviewServiceImpl implements ReviewService {

    private ReviewDAO reviewDAO;
    private UserService userService;

    @Autowired
    public ReviewServiceImpl(ReviewDAO reviewDAO, UserService userService) {
        this.reviewDAO = reviewDAO;
        this.userService = userService;
    }

    public ReviewServiceImpl() {
        super();
    }

    @Override
    public Review getByID(Integer id) {
        return reviewDAO.getByID(id);
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

    @Override
    public List<Review> getByHotelId(int hotelId) {
        return reviewDAO.getByHotelId(hotelId);
    }

    @Override
    public List<Review> getApprovedByHotelId(int hotelId) {
        List<Review> allReviews = reviewDAO.getByHotelId(hotelId);
        List<Review> approvedReviews = new ArrayList<Review>();
        for (Review review : allReviews) {
            if (review.getStatus().equals("approved")) {
                approvedReviews.add(review);
            }
        }
        return approvedReviews;
    }

    @Override
    public boolean update(Review review) {
        try {
            reviewDAO.update(review);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ReviewDAO getReviewDAO() {
        return reviewDAO;
    }

    public void setReviewDAO(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

}
