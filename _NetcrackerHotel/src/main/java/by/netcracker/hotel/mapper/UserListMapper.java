package by.netcracker.hotel.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.jdbc.core.RowMapper;

import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.entities.User;

public class UserListMapper implements RowMapper<Map<String, User>> {

	@Override
	public Map<String, User> mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Map<String, User> map = new TreeMap<String, User>();
		do {
			String id = resultSet.getString(1);
			if (!map.containsKey(id)) {
				map.put(id, new User());
			}
			switch (resultSet.getString(2)) {
			case ColumnName.USER_FIRST_NAME: {
				map.get(id).setFirstName(resultSet.getString(3));
				break;
			}
			case ColumnName.USER_LAST_NAME: {
				map.get(id).setLastName(resultSet.getString(3));
				break;
			}
			case ColumnName.USER_USERNAME: {
				map.get(id).setLastName(resultSet.getString(3));
				break;
			}
			case ColumnName.USER_EMAIL: {
				map.get(id).setEmail(resultSet.getString(3));
				break;
			}
			case ColumnName.USER_AUTHORITY: {
				map.get(id).setAuthority(resultSet.getString(3));
				break;
			}
			case ColumnName.USER_ENABLED: {
				map.get(id).setEnabled((resultSet.getString(3)).equals("1") ? true : false);
				break;
			}
			}

		} while (resultSet.next());

		return map;
	}

}
