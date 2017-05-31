package by.netcracker.hotel.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.constants.ColumnName;
import by.netcracker.hotel.dao.constants.TypeName;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mappers.HotelMapper;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Varvara on 4/4/2017.
 */
@Repository
@Singleton
public class HotelDAOImpl extends JdbcDaoSupport implements HotelDAO {

    private static Logger log = Logger.getLogger(HotelDAOImpl.class);
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
    public void update(Hotel hotel) {
        update(hotel.getAddress(), ColumnName.HOTEL_ADDRESS, hotel.getId());
        update(hotel.getCity(), ColumnName.HOTEL_CITY, hotel.getId());
        update(hotel.getCountry(), ColumnName.HOTEL_COUNTRY, hotel.getId());
        update(hotel.getDescription(), ColumnName.HOTEL_DESCRIPTION, hotel.getId());
        update(hotel.getEnabled(), ColumnName.HOTEL_ENABLED, hotel.getId());
        update(hotel.getName(), ColumnName.HOTEL_NAME, hotel.getId());
        update(hotel.getMainPhoto(), ColumnName.HOTEL_MAIN_PHOTO, hotel.getId());
    }

    private boolean update(Object value, Object column, Object id) {
        try {
            if (value == null) {
                return false;
            } else {
                getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), value, column, id);
                return true;
            }
        } catch (Exception e) {
            log.info("Exception in hotelDAO while updating");
            return false;
        }
    }

    @Override
    public Hotel getByID(Integer id) {
        Hotel hotel = new Hotel();
        try {
            hotel = getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new HotelMapper());
        } catch (EmptyResultDataAccessException e) {
            log.info("Exception in hotelDAO while getting by id");
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
            log.info("EmptyResultDataAccessException in hotelDAO while getting by name");
            return null;
        }
    }

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
        query.append(SqlQuery.FIND_HOTELS_BY_SEARCH_STRINGS_END.getQuery());
        return getJdbcTemplate().query(query.toString(), param.toArray(),
            new RowMapperResultSetExtractor<Hotel>(new HotelMapper()) {
            });
    }

    @Override
    public void deletePhoto(String photo) {
        getJdbcTemplate().update(SqlQuery.DELETE_PHOTO.getQuery(), photo);

    }

}
