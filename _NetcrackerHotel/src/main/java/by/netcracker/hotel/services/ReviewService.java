package by.netcracker.hotel.services;

import java.util.List;

import by.netcracker.hotel.entities.Review;

public interface ReviewService extends AbstractService<Review, Integer> {

    void addReview(Review review);

    String checkReview(int hotelId);

    public List<Review> getByHotelId(int hotelId);

    public List<Review> getApprovedByHotelId(int hotelId);

    boolean update(Review review);
}
