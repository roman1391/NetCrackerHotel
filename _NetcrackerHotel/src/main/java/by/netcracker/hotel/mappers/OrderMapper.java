package by.netcracker.hotel.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.netcracker.hotel.dao.constants.ColumnName;
import by.netcracker.hotel.entities.Order;

/**
 * Created by Alexander on 25.04.2017.
 */
public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        int currentID = resultSet.getInt(1);
        order.setId(currentID);
        do {
            if (currentID != resultSet.getInt(1)) {
                resultSet.previous();
                break;
            }
            switch (resultSet.getString(2)) {
            case ColumnName.ORDER_USER_ID: {
                order.setUserId(resultSet.getInt(3));
                break;
            }
            case ColumnName.ORDER_ROOM_ID: {
                order.setRoomId(resultSet.getInt(3));
                break;
            }
            case ColumnName.ORDER_HOTEL: {
                order.setHotelname(resultSet.getString(3));
                break;
            }
            case ColumnName.ORDER_USERNAME: {
                order.setUsername(resultSet.getString(3));
                break;
            }
            case ColumnName.HOTEL_ARRIVAL_DATE: {
                order.setArrivalDate(resultSet.getDate(3));
                break;
            }
            case ColumnName.HOTEL_LEAVE_DATE: {
                order.setLeaveDate(resultSet.getDate(3));
                break;
            }
            case ColumnName.ORDER_PAY_VALUE: {
                order.setPayValue(resultSet.getInt(3));
                break;
            }
            case ColumnName.ORDER_IS_PAID: {
                order.setPaid(resultSet.getBoolean(3));
                break;
            }
            case ColumnName.ORDER_FIRST_NAME: {
                order.setFirstName(resultSet.getString(3));
                break;
            }
            case ColumnName.ORDER_LAST_NAME: {
                order.setLastName(resultSet.getString(3));
                break;
            }
            }
        } while (resultSet.next());
        return order;
    }
}