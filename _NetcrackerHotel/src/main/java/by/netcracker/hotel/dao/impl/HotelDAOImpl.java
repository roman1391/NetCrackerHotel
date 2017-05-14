package by.netcracker.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
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
import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.mapper.HotelMapper;

/**
 * Created by Varvara on 4/4/2017.
 */
@Repository
@Singleton
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
                    new String[] { "id" });
                ps.setString(1, TypeName.HOTEL.name().toLowerCase());
                return ps;
            }
        }, keyHolder);
        hotel.setId(keyHolder.getKey().intValue());
        getJdbcTemplate().update(SqlQuery.ADD_HOTEL.getQuery(), hotel.getCountry(), hotel.getCity(), hotel.getAddress(),
            hotel.getTypeOfService(), hotel.getName(), hotel.getDescription(), hotel.getEnabled(),
            getPhotoName(hotel.getMainPhoto()));
        for (String photo : hotel.getPhotos()) {
            getJdbcTemplate().update(SqlQuery.ADD_PHOTO.getQuery(), hotel.getId(), getPhotoName(photo));
        }

    }

    private String getPhotoName(String photo) {
        String[] urlParts = photo.split("[./]");
        return urlParts[urlParts.length - 2];
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
            hotel = getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new HotelMapper());
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
        searchString = "%searchString%";
        return getJdbcTemplate().query(SqlQuery.SEARCH_HOTEL.getQuery(), new Object[] { searchString, searchString },
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

    @Override
    public Hotel getByName(String name) {
        try {
            return (Hotel) getJdbcTemplate().queryForObject(SqlQuery.GET_BY.getQuery(),
                new Object[] { ColumnName.HOTEL_NAME, name }, new HotelMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /*
     * @Override public List<Hotel> findHotelsBySearchStrings(List<String>
     * searchStrings) { StringBuilder parametrs = new
     * StringBuilder("value.attribute_value like '%" + searchStrings.get(0) +
     * "%'"); for (int i = 1; i < searchStrings.size(); i++) {
     * parametrs.append("or value.attribute_value like '%" +
     * searchStrings.get(i) + "%'"); } String query =
     * SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_BEGIN.getQuery() + " (" +
     * parametrs.toString() + ")) ORDER BY entity_id"; return
     * getJdbcTemplate().query(query, new RowMapperResultSetExtractor<Hotel>(new
     * HotelMapper()) { }); }
     */
    @Override
    public List<Hotel> findHotelsBySearchStrings(List<String> searchStrings, SearchFilter searchFilter) {
        StringBuilder query = new StringBuilder(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_BEGIN.getQuery());
        List<Object> param = new ArrayList<>();
        query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_STRING_FIRST.getQuery());
        for (int i = 1; i < searchStrings.size(); i++) {
            query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_STRING.getQuery());
        }
        for (String searchString : searchStrings) {
            param.add("%" + searchString + "%");
        }
        query.append(")) ");
        if (searchFilter.getStars().length > 0) {
            query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_STAR_FIRST.getQuery());
            for (int i = 1; i < searchFilter.getStars().length; i++) {
                query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_STAR.getQuery());
            }
            query.append(")))");
            for (int star : searchFilter.getStars()) {
                param.add(star);
            }
        }
        if (searchFilter.getCapacity() != null || searchFilter.getMaxCost() != null
            || searchFilter.getMinCost() != null) {
            query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_ROOM.getQuery());
            if (searchFilter.getCapacity() != null) {
                query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_CAPACITY.getQuery());
                param.add(searchFilter.getCapacity());
            }
            if (searchFilter.getMaxCost() != null && searchFilter.getMinCost() != null) {
                query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_MIN_MAX_COST.getQuery());
                param.add(searchFilter.getMinCost());
                param.add(searchFilter.getMaxCost());
            } else {
                if (searchFilter.getMaxCost() != null) {
                    query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_MAX_COST.getQuery());
                    param.add(searchFilter.getMaxCost());
                }
                if (searchFilter.getMinCost() != null) {
                    query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_MIN_COST.getQuery());
                    param.add(searchFilter.getMinCost());
                }
            }
            query.append("))");
        }
        return getJdbcTemplate().query(query.toString(), param.toArray(),
            new RowMapperResultSetExtractor<Hotel>(new HotelMapper()) {
            });
    }
}
