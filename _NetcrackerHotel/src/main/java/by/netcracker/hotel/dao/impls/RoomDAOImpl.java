package by.netcracker.hotel.dao.impls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.dao.constants.TypeName;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mappers.RoomMapper;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Varvara on 4/25/2017.
 */
@Repository
@Singleton
public class RoomDAOImpl extends JdbcDaoSupport implements RoomDAO {

    private static Logger log = Logger.getLogger(RoomDAOImpl.class);
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public RoomDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Room room) {
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.ROOM.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_ROOM.getQuery(), room.getCapacity(), room.getCost(), room.getHotelID());
    }

    @Override
    public void deleteByID(Integer id) {
        getJdbcTemplate().update(SqlQuery.DELETE_BY_ID.getQuery(), id);
    }

    @Override
    public void update(Room entity) {

    }

    @Override
    public Room getByID(Integer id) {
        try {
            return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new RoomMapper());
        } catch (EmptyResultDataAccessException e) {
            log.warn("EmptyResultDataAccessException in roomDAO while getting by id", e);
            return null;
        }
    }

    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public List<Room> getByHotelID(int hotelID) {
        return getJdbcTemplate().query(SqlQuery.GET_ROOMS_BY_HOTEL_ID.getQuery(), new Object[] { hotelID },
            new RowMapperResultSetExtractor<Room>(new RoomMapper()) {
            });
    }

    @Override
    public List<Room> getFreeRoomsInHotelByDate(int hotelID, Date start, Date end) {
        return getJdbcTemplate().query(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_BY_DATE.getQuery(),
            new Object[] { hotelID, start, end }, new RowMapperResultSetExtractor<Room>(new RoomMapper()) {
            });
    }

    @Override
    public List<Room> getFreeRoomsInHotelByDate(SearchFilter searchFilter, int hotelID) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        StringBuilder query = new StringBuilder(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_BEGIN.getQuery());
        List<Object> param = new ArrayList<>();
        if (searchFilter.getCapacity() != null) {
            query.append(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_CAPACITY.getQuery());
            param.add(searchFilter.getCapacity());
        }
        if (searchFilter.getMinCost() != null && searchFilter.getMaxCost() != null) {
            query.append(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_MIN_MAX_COST.getQuery());
            param.add(searchFilter.getMinCost());
            param.add(searchFilter.getMaxCost());
        } else {
            if (searchFilter.getMinCost() != null) {
                query.append(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_MIN_COST.getQuery());
                param.add(searchFilter.getMinCost());
            }
            if (searchFilter.getMaxCost() != null) {
                query.append(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_MAX_COST.getQuery());
                param.add(searchFilter.getMaxCost());
            }
        }
        if (!StringUtils.isBlank(searchFilter.getStartDate()) && !StringUtils.isBlank(searchFilter.getEndDate())) {
            query.append(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_DATE.getQuery());
            try {
                param.add(dateFormat.parse(searchFilter.getStartDate()));
                param.add(dateFormat.parse(searchFilter.getEndDate()));
            } catch (ParseException e) {
                log.warn("ParseException in roomDAO while getting free rooms", e);
            }
        }
        query.append(SqlQuery.GET_FREE_ROOMS_IN_HOTEL_END.getQuery());
        param.add(hotelID);
        return getJdbcTemplate().query(query.toString(), param.toArray(),
            new RowMapperResultSetExtractor<Room>(new RoomMapper()) {
            });
    }

    @Override
    public boolean isRoomFree(int roomId, int orderId, SearchFilter searchFilter) {
        try {
            getJdbcTemplate().queryForObject(SqlQuery.GET_ISFREE_IN_HOTEL_END.getQuery(),
                new Object[] { orderId, searchFilter.getStartDate(), searchFilter.getEndDate(), roomId },
                new RoomMapper());
            return true;
        } catch (EmptyResultDataAccessException ex) {
            log.warn("EmptyResultDataAccessException in roomDAO while getting free rooms", ex);
            return false;
        }
    }
}
