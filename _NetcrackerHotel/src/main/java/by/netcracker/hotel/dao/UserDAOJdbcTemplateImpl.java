package by.netcracker.hotel.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import by.netcracker.hotel.entities.User;

@Component("UserDAOJdbcTemplateImpl")
public class UserDAOJdbcTemplateImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private static final String SQL_QUERY_GET_CLIENTS = "INSERT INTO `netcracker_hotel`.`users` (`first_name`, `last_name`, `login`, `password`, `email`) VALUES (?, ?, ?, ?, ?);";

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void regUser(User user) {
		jdbcTemplate.update(SQL_QUERY_GET_CLIENTS, new Object[] { user.getFirstName(), user.getLastName(),
				user.getLogin(), user.getPassword(), user.getEmail() });

	}

	@Override
	public void loginUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void blockUser(User user) {
		// TODO Auto-generated method stub

	}

}
