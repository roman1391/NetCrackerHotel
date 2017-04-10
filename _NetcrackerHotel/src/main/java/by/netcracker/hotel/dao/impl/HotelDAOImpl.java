package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

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
    public void add(Hotel entity) throws SQLException {

    }

    @Override
    public void deleteByID(Integer integer) throws SQLException {

    }

    @Override
    public Hotel update(Hotel entity) throws SQLException {
        return null;
    }

    @Override
    public Hotel getByID(Integer id) {
        try {
            return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(),
                    new Object[]{id}, new HotelMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Hotel> getAll() throws SQLException {
        return null;
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
}
