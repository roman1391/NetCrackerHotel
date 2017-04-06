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
        do {
            switch (resultSet.getString(1)){
                case "first_name" :{
                    user.setFirstName(resultSet.getString(2));
                    break;
                }
                case "last_name" :{
                    user.setLastName(resultSet.getString(2));
                    break;
                }
                case "username" :{
                    user.setUsername(resultSet.getString(2));
                    break;
                }
                case "email" :{
                     user.setEmail(resultSet.getString(2));
                     break;
                }
                case "password" :{
                     user.setPassword(resultSet.getString(2));
                     break;
                }
                case "accesslevel" :{
                    user.setAccessLevel(Integer.parseInt(resultSet.getString(2)));
                    break;
                }
            }
        } while (resultSet.next());
        return user;
    }
}
