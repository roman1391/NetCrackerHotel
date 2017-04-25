package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Varvara on 4/25/2017.
 */
@Repository
public class RoomDAOImpl  extends JdbcDaoSupport implements RoomDAO {
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
    public void deleteByID(Integer integer) {

    }

    @Override
    public void update(Room entity) {

    }

    @Override
    public Room getByID(Integer integer) {
        return null;
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
}
