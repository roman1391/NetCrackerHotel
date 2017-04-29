package by.netcracker.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.HotelMapper;

/**
 * Created by Varvara on 4/4/2017.
 */
@Repository
public class HotelDAOImpl extends JdbcDaoSupport implements HotelDAO {

    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public HotelDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Hotel hotel) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SqlQuery.ADD_ENTITY_ID.getQuery(),
                        new String[]{"id"});
                ps.setString(1, TypeName.HOTEL.name().toLowerCase());
                return ps;
            }
        }, keyHolder);
        hotel.setId(keyHolder.getKey().intValue());
        getJdbcTemplate().update(SqlQuery.ADD_HOTEL.getQuery(), hotel.getCountry(), hotel.getCity(), hotel.getAddress(),
                hotel.getTypeOfService(), hotel.getName(), hotel.getDescription(), getPhotoName(hotel.getMainPhoto()));
        for (String photo : hotel.getPhotos()) {
            getJdbcTemplate().update(SqlQuery.ADD_PHOTO.getQuery(), hotel.getId(), getPhotoName(photo));
        }

    }

    private String getPhotoName(String photo) {
        String[] urlParts = photo.split("[./]");
        return urlParts[urlParts.length-2];
    }

    @Override
    public void deleteByID(Integer id) {
        getJdbcTemplate().update(SqlQuery.DELETE_BY_ID.getQuery(), id);
    }

    @Override
    public void update(Hotel entity) {

    }

    @Override
    public Hotel getByID(Integer id) {
        Hotel hotel = new Hotel();
        try {
            hotel = getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[]{id},
                    new HotelMapper());
        } catch (EmptyResultDataAccessException e) {
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        return getJdbcTemplate().query(SqlQuery.GET_ALL.getQuery(), new Object[]{TypeName.HOTEL.getType()},
                new RowMapperResultSetExtractor<Hotel>(new HotelMapper()) {
                });
    }

    @Override
    public List<Integer> findIDsBySearchString(String searchString) {
        String searchString1 = "% " + searchString + " %";
        String searchString2 = searchString + " %";
        String searchString3 = "% " + searchString;
        return getJdbcTemplate().query(SqlQuery.SEARCH_HOTEL.getQuery(), new Object[]{searchString, searchString1, searchString2, searchString3},
                (resultSet, i) -> resultSet.getInt(1));
    }

    @Override
    public List<String> getPlaces() {
        return getJdbcTemplate().query(SqlQuery.GET_PLACES.getQuery(), (resultSet, i) -> resultSet.getString(1));
    }

    @Override
    public void addPhoto(String photo, int hotelID) {
            getJdbcTemplate().update(SqlQuery.ADD_PHOTO.getQuery(), hotelID, photo);
    }

    @Override
    public List<String> getHotelNames() {
        return getJdbcTemplate().query(SqlQuery.GET_HOTEL_NAMES.getQuery(), (resultSet, i) -> resultSet.getString(1));
    }

}
