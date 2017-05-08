package by.netcracker.hotel.services.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.Review;

public class ReviewServiceImplTest {

    @Mock
    ReviewDAO reviewDAO;
    @Mock
    UserDAO userDAO;
    private ReviewServiceImpl reviewService;

    @Before
    public void setup() {
        System.out.println("Setup");
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewServiceImpl();
        reviewService.setReviewDAO(reviewDAO);
    }

    @Test
    public void addReviewTest() {
        Review review = new Review(7777, 8888, 9999, "testUser", "testHotel", "text", "testStatus", "testDate", 5);
        reviewService.addReview(review);
        assertTrue(review.getStatus().equals("pending"));
        assertTrue(review.getDate().equals(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())));
        verify(reviewDAO).add(review);
    }

}
