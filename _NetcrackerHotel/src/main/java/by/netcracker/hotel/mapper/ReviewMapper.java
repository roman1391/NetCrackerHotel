package by.netcracker.hotel.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.entities.Review;

public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Review review = new Review();
        int currentID = resultSet.getInt(1);
        review.setId(currentID);
        do {
            if (currentID != resultSet.getInt(1)) {
                resultSet.previous();
                break;
            }
            switch (resultSet.getString(2)) {
            case ColumnName.REVIEW_USERID: {
                review.setUserId(Integer.parseInt(resultSet.getString(3)));
                break;
            }
            case ColumnName.REVIEW_USERNAME: {
                review.setUsername(resultSet.getString(3));
                break;
            }
            case ColumnName.REVIEW_HOTELID: {
                review.setHotelId(Integer.parseInt(resultSet.getString(3)));
                break;
            }
            case ColumnName.REVIEW_HOTELNAME: {
                review.setHotelname(resultSet.getString(3));
                break;
            }
            case ColumnName.REVIEW_FEEDBACK: {
                review.setText(resultSet.getString(3));
                break;
            }
            case ColumnName.REVIEW_STATUS: {
                review.setStatus(resultSet.getString(3));
                break;
            }
            case ColumnName.REVIEW_TIME: {
                review.setDate(resultSet.getString(3));
                break;
            }
            case ColumnName.REVIEW_STAR: {
                review.setRating(Integer.parseInt(resultSet.getString(3)));
                break;
            }
            }
        } while (resultSet.next());
        return review;
    }

}
