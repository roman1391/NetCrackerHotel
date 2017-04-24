package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.Review;

public interface ReviewDAO extends AbstractDAO<Review, Integer> {

    String checkUsersReview(int hotelId, int id);

}
