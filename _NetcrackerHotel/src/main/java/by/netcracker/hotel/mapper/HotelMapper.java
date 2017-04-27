package by.netcracker.hotel.mapper;

import by.netcracker.hotel.cloud.CloudinaryConnector;
import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.entities.Hotel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Varvara on 4/8/2017.
 */
public class HotelMapper implements RowMapper<Hotel> {
    @Override
    public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {
        Hotel hotel = new Hotel();
        int currentID = resultSet.getInt(1);
        hotel.setId(currentID);
        do {
            if (currentID != resultSet.getInt(1)) {
                resultSet.previous();
                break;
            }
            switch (resultSet.getString(2)) {
                case ColumnName.COUNTRY: {
                    hotel.setCountry(resultSet.getString(3));
                    break;
                }
                case ColumnName.CITY: {
                    hotel.setCity(resultSet.getString(3));
                    break;
                }
                case ColumnName.ADDRESS: {
                    hotel.setAddress(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_NAME: {
                    hotel.setName(resultSet.getString(3));
                    break;
                }
                case ColumnName.CLASS: {
                    hotel.setTypeOfService(resultSet.getInt(3));
                    break;
                }
                case ColumnName.MAIN_PHOTO: {
                    hotel.setMainPhoto(resultSet.getString(3));
                    break;
                }
                case ColumnName.PHOTO: {
                    hotel.addPhoto(resultSet.getString(3));
                    break;
                }
            }
        } while (resultSet.next());
        return hotel;
    }
}
