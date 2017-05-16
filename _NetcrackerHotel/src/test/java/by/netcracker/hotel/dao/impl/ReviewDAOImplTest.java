package by.netcracker.hotel.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import by.netcracker.hotel.entities.Review;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test/root-context.xml", "/spring-test/mysql-datasource.xml",
        "/spring-test/servlet-context.xml" })
@WebAppConfiguration
public class ReviewDAOImplTest {

    @Autowired
    private ReviewDAOImpl reviewDAO;
    private List<Review> list;
    private Review review;

    @Before
    public void setup() {
        review = new Review(7777, 8888, 9999, "testUser", "testHotel", "testText", "testStatus", "testDate", 5);
    }

    @Test
    public void addTest() {
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review newReview = list.get(0);
        review.setId(newReview.getId());
        assertTrue(review.equals(newReview));
        reviewDAO.deleteByID(newReview.getId());
    }

    @Test
    public void deleteByIDTest() {
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review newReview = list.get(0);
        review.setId(newReview.getId());
        reviewDAO.deleteByID(newReview.getId());
        newReview = reviewDAO.getByID(newReview.getId());
        assertNull(newReview);
    }

    @Test
    public void checkUsersReviewTest_ShouldReturnExist() {
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review newReview = list.get(0);
        review.setId(newReview.getId());
        String result = reviewDAO.checkUsersReview(review.getHotelId(), review.getUserId());
        reviewDAO.deleteByID(newReview.getId());
        assertTrue(result.equals("exist"));
    }

    @Test
    public void checkUsersReviewTest_ShouldReturnNotExist() {
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review newReview = list.get(0);
        reviewDAO.deleteByID(newReview.getId());
        String result = reviewDAO.checkUsersReview(review.getHotelId(), review.getUserId());
        assertTrue(result.equals("notExist"));
    }

    // @Test
    public void checkUsersReviewTest_ShouldReturnExistInException() {
        reviewDAO.add(review);
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review newReview1 = list.get(0);
        Review newReview2 = list.get(1);
        String result = reviewDAO.checkUsersReview(review.getHotelId(), review.getUserId());
        reviewDAO.deleteByID(newReview1.getId());
        reviewDAO.deleteByID(newReview2.getId());
        assertTrue(result.equals("exist"));
    }

    @Test
    public void updateTest() {
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review newReview = list.get(0);
        newReview.setStatus("approved");
        reviewDAO.update(newReview);
        Review updatedReview = reviewDAO.getByID(newReview.getId());
        reviewDAO.deleteByID(updatedReview.getId());
        // assertTrue(updatedReview.getStatus().equals("approved"));
        assertEquals("status is not changed", "approved", updatedReview.getStatus());
    }

}
