package by.netcracker.hotel.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.netcracker.hotel.dao.constants.ColumnName;
import by.netcracker.hotel.entities.Hotel;

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
                case ColumnName.HOTEL_COUNTRY: {
                    hotel.setCountry(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_CITY: {
                    hotel.setCity(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_ADDRESS: {
                    hotel.setAddress(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_NAME: {
                    hotel.setName(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_CLASS: {
                    hotel.setTypeOfService(resultSet.getInt(3));
                    break;
                }
                case ColumnName.HOTEL_MAIN_PHOTO: {
                    hotel.setMainPhoto(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_PHOTO: {
                    hotel.addPhoto(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_DESCRIPTION: {
                    hotel.setDescription(resultSet.getString(3));
                    break;
                }
                case ColumnName.HOTEL_ENABLED: {
                    if (Integer.parseInt(resultSet.getString(3)) == 1) {
                        hotel.setEnabled(true);
                    } else {
                        hotel.setEnabled(false);
                    }
                    break;
                }
            }
        } while (resultSet.next());
        return hotel;
    }
}
