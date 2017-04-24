package by.netcracker.hotel.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.enums.SqlQuery;

@Component("ReviewDAOImpl")
public class ReviewDAOImpl extends JdbcDaoSupport implements ReviewDAO {
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public ReviewDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Review review) {
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.REVIEW.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_REVIEW.getQuery(), review.getUserId(), review.getHotelId(),
            review.getText(), review.getStatus(), review.getDate(), String.valueOf(review.getRating()));
    }

    @Override
    public void deleteByID(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Review entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Review getByID(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Review> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String checkUsersReview(int hotelId, int userId) {
        String reviewExist;
        try {
            reviewExist = getJdbcTemplate().queryForObject(SqlQuery.CHECK_REVIEW.getQuery(), String.class,
                new Object[] { userId, hotelId });
        } catch (Exception e) {
            reviewExist = "1";
        }
        System.out.println(hotelId);
        System.out.println(userId);
        System.out.println("запрос - " + reviewExist);
        return reviewExist;
    }

}
