package by.netcracker.hotel.services.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.entities.Review;

public class ReviewServiceImplTest {

    @Mock
    ReviewDAO reviewDAO;
    private Review review = new Review();
    private ReviewServiceImpl reviewService = new ReviewServiceImpl();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        reviewService.setReviewDAO(reviewDAO);
    }

    @Test
    public void addReviewTest() {
        reviewService.addReview(review);
        verify(reviewDAO).add(review);
    }

    @Test
    public void getByHotelIdTest() {
        reviewService.getByHotelId(77);
        verify(reviewDAO).getByHotelId(77);
    }

    @Test
    public void updateTest() {
        reviewService.update(review);
        verify(reviewDAO).update(review);
    }

    @Test
    public void getApprovedByHotelIdTest() {
        boolean allApproved = true;
        List<Review> list = Arrays.asList(
            new Review(7777, 8888, 9999, "testUser", "testHotel", "text", "testStatus", "testDate", 5),
            new Review(7777, 8888, 9999, "testUser", "testHotel", "text", "approved", "testDate", 5));
        when(reviewDAO.getByHotelId(77)).thenReturn(list);
        List<Review> approvedReviews = reviewService.getApprovedByHotelId(77);
        for (Review review : approvedReviews) {
            if (!review.getStatus().equals("approved")) {
                allApproved = false;
            }
        }
        assertTrue(allApproved);
    }

}
