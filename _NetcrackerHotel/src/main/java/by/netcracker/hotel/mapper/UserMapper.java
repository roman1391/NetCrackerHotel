package by.netcracker.hotel.mapper;

import by.netcracker.hotel.dao.constant.ColumnName;
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
                case ColumnName.USER_FIRST_NAME :{
                    user.setFirstName(resultSet.getString(2));
                    break;
                }
                case ColumnName.USER_LAST_NAME :{
                    user.setLastName(resultSet.getString(2));
                    break;
                }
                case ColumnName.USER_USERNAME :{
                    user.setUsername(resultSet.getString(2));
                    break;
                }
                case ColumnName.USER_EMAIL :{
                     user.setEmail(resultSet.getString(2));
                     break;
                }
                case ColumnName.USER_PASSWORD :{
                     user.setPassword(resultSet.getString(2));
                     break;
                }
                case ColumnName.USER_ACCESS_LEVEL :{
                    user.setAccessLevel(Integer.parseInt(resultSet.getString(2)));
                    break;
                }
            }
        } while (resultSet.next());
        return user;
    }
}
