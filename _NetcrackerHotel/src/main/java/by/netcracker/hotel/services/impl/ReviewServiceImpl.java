package by.netcracker.hotel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.services.ReviewService;

@Service("ReviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDAO reviewDAO;

    @Autowired
    public ReviewServiceImpl(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    @Override
    public Review getByID(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addReview(Review review) {
        review.setDate("today");
        review.setRating(55);
        reviewDAO.add(review);
    }
}
