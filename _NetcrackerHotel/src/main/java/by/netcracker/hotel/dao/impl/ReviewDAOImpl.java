package by.netcracker.hotel.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.ReviewMapper;
import by.netcracker.hotel.mapper.UserMapper;

@Repository
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
        getJdbcTemplate().update(SqlQuery.DELETE_BY_ID.getQuery(), id);

    }

    @Override
    public void update(Review entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Review getByID(Integer id) {
        try {
            return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new ReviewMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Review> getAll() {
        return getJdbcTemplate().query(SqlQuery.GET_ALL.getQuery(), new Object[] { TypeName.REVIEW.getType() },
            new RowMapperResultSetExtractor<Review>(new ReviewMapper()) {
            });
    }

    @Override
    public String checkUsersReview(int hotelId, int userId) {
        String reviewStatus;
        String reviewinfo;
        try {
            reviewStatus = getJdbcTemplate().queryForObject(SqlQuery.CHECK_REVIEW.getQuery(), String.class,
                new Object[] { userId, hotelId });
        } catch (Exception e) {
            reviewStatus = "1";
        }
        switch (reviewStatus) {
        case "1":
            reviewinfo = "exist";
            break;
        case "0":
            reviewinfo = "notExist";
            break;
        default:
            reviewinfo = "exist";
            break;
        }
        return reviewinfo;
    }

}