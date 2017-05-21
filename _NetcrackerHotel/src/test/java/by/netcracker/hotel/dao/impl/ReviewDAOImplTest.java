package by.netcracker.hotel.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.enums.ReviewStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test/root-context.xml", "/spring-test/mysql-datasource.xml",
        "/spring-test/servlet-context.xml" })
@WebAppConfiguration
public class ReviewDAOImplTest {

    @Autowired
    private ReviewDAOImpl reviewDAO;
    private List<Review> list;
    private Review testReview;
    Review retrievedReview;
    Review retrievedReview2;

    @Before
    public void setup() {
        testReview = new Review(7777, 8888, 9999, "testUser", "testHotel", "testText",
            ReviewStatus.PENDING.getReviewInfo(), "testDate", 5);
    }

    @After
    public void end() {
        if (retrievedReview != null) {
            reviewDAO.deleteByID(retrievedReview.getId());
        }
        if (retrievedReview2 != null) {
            reviewDAO.deleteByID(retrievedReview2.getId());
        }
    }

    // adding testReview to db and getting back to new variable
    private Review getAddedReview(Review review) {
        reviewDAO.add(review);
        list = reviewDAO.getByHotelId(review.getHotelId());
        Review retrievedReview = list.get(0);
        return retrievedReview;
    }

    @Test
    public void addTest() {
        list = reviewDAO.getByHotelId(testReview.getHotelId());
        assertTrue("database contains testing review", list.size() == 0);
        retrievedReview = getAddedReview(testReview);
        testReview.setId(retrievedReview.getId()); // testReview doesn't
                                                   // contains id by default
        assertEquals("Reviews are not equal while adding review!", testReview, retrievedReview);
    }

    @Test
    public void deleteByIDTest() {
        retrievedReview = getAddedReview(testReview);
        testReview.setId(retrievedReview.getId());
        assertEquals("Reviews are not equal while adding review!", testReview, retrievedReview);
        reviewDAO.deleteByID(retrievedReview.getId());
        retrievedReview = reviewDAO.getByID(retrievedReview.getId());
        assertNull(retrievedReview);
    }

    @Test
    public void checkUsersReviewTest_Exist_Case() {
        retrievedReview = getAddedReview(testReview);
        boolean reviewExist = reviewDAO.checkUsersReview(testReview.getHotelId(), testReview.getUserId());
        assertTrue(reviewExist);
    }

    @Test
    public void checkUsersReviewTest_NotExist_Case() {
        retrievedReview = getAddedReview(testReview);
        reviewDAO.deleteByID(retrievedReview.getId());
        boolean reviewExist = reviewDAO.checkUsersReview(testReview.getHotelId(), testReview.getUserId());
        assertFalse(reviewExist);
    }

    // @Test
    public void checkUsersReviewTest_ExistInException_Case() {
        reviewDAO.add(testReview);
        retrievedReview = getAddedReview(testReview);
        boolean reviewExist = reviewDAO.checkUsersReview(testReview.getHotelId(), testReview.getUserId());
        assertTrue(reviewExist);
    }

    @Test
    public void updateTest() {
        retrievedReview = getAddedReview(testReview);
        assertEquals("retrievedReview has wrong status", retrievedReview.getStatus(),
            ReviewStatus.PENDING.getReviewInfo());
        retrievedReview.setStatus(ReviewStatus.APPROVED.getReviewInfo());
        reviewDAO.update(retrievedReview);
        Review retrievedReview2 = reviewDAO.getByID(retrievedReview.getId());
        assertEquals("status is not changed", "approved", retrievedReview2.getStatus());
    }

}
