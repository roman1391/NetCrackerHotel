package by.netcracker.hotel.mapper;

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
        do {
            switch (resultSet.getString(1)){
                case ColumnName.COUNTRY :{
                    hotel.setCountry(resultSet.getString(2));
                    break;
                }
                case ColumnName.CITY :{
                    hotel.setCity(resultSet.getString(2));
                    break;
                }
                case ColumnName.ADDRESS :{
                    hotel.setAddress(resultSet.getString(2));
                    break;
                }
                case ColumnName.HOTEL_NAME :{
                    hotel.setName(resultSet.getString(2));
                    break;
                }
                case ColumnName.CLASS :{
                    hotel.setTypeOfService(resultSet.getInt(2));
                    break;
                }
            }
        } while (resultSet.next());
        return hotel;
    }
}
