package by.netcracker.hotel.mapper;

import by.netcracker.hotel.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by slava on 02.04.17.
 */
public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        System.out.println(resultSet);
        return null;
    }
}
