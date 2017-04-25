package by.netcracker.hotel.mapper;

import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.entities.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Varvara on 4/25/2017.
 */
public class RoomMapper implements RowMapper<Room> {
    @Override
    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room room = new Room();
        int currentID = resultSet.getInt(1);
        room.setId(currentID);
        do {
            if (currentID != resultSet.getInt(1)) {
                resultSet.previous();
                break;
            }
            switch (resultSet.getString(2)) {
                case ColumnName.CAPACITY: {
                    room.setCapacity(resultSet.getInt(3));
                    break;
                }
                case ColumnName.COST: {
                    room.setCost(resultSet.getInt(3));
                    break;
                }
                case ColumnName.HOTEL_ID: {
                    room.setHotelID(resultSet.getInt(3));
                    break;
                }
            }
        } while (resultSet.next());
        return room;
    }
}
