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

import by.netcracker.hotel.cloud.CloudinaryConnector;
import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.HotelMapper;
import by.netcracker.hotel.mapper.PhotoMapper;

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

        getJdbcTemplate().update(SqlQuery.ADD_HOTEL.getQuery(), hotel.getCountry(), hotel.getCity(),
                hotel.getAddress(), hotel.getTypeOfService(), hotel.getName(), hotel.getDescription());
        hotel.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void deleteByID(Integer integer) {

    }

    @Override
    public void update(Hotel entity) {

    }

    @Override
    public Hotel getByID(Integer id) {
        Hotel hotel = new Hotel();
        try {
            hotel = getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new HotelMapper());
            Photo photo = getJdbcTemplate().queryForObject(SqlQuery.GET_MAIN_PHOTO_FOR_HOTEL.getQuery(),
                    new Object[]{id}, new PhotoMapper());
            hotel.setPhotoURL(CloudinaryConnector.getCloudinary().url().format("jpg").generate(photo.getPhotoName()));
        } catch (EmptyResultDataAccessException e) {
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        return getJdbcTemplate().query(SqlQuery.GET_ALL.getQuery(), new Object[] { TypeName.HOTEL.getType() },
            new RowMapperResultSetExtractor<Hotel>(new HotelMapper()) {
            });
    }

    @Override
    public List<Integer> findIDsBySearchString(String searchString) {
        searchString = "%" + searchString + "%";
        return getJdbcTemplate().query(SqlQuery.SEARCH_HOTEL.getQuery(), new Object[]{searchString},
                (resultSet, i) -> resultSet.getInt(1));
    }

    @Override
    public List<String> getPlaces() {
        return getJdbcTemplate().query(SqlQuery.GET_PLACES.getQuery(),
                (resultSet, i) -> resultSet.getString(1));
    }

    @Override
    public void setMainPhotoForHotel(int idHotel, int idPhoto) {
        getJdbcTemplate().update(SqlQuery.SET_MAIN_PHOTO_FOR_HOTEL.getQuery(), idHotel, idPhoto);
    }

}
