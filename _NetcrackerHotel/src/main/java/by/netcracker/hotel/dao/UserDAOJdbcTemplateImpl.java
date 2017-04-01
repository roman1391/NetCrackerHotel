package by.netcracker.hotel.dao;

import javax.sql.DataSource;

import by.netcracker.hotel.enums.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import by.netcracker.hotel.entities.User;

@Component("UserDAOJdbcTemplateImpl")
public class UserDAOJdbcTemplateImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void regUser(User user) {

		jdbcTemplate.update(SqlQuery.ADD.getQuery());
		jdbcTemplate.update(SqlQuery.REGISTRATION.getQuery(), new Object[] { user.getFirstName(), user.getLastName(), user.getLogin(),
				user.getPassword(), user.getEmail() });

	}

	@Override
	public User loginUser(User user) {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlQuery.LOGIN.getQuery(),
				new Object[] { user.getLogin(), user.getPassword() });

		while (rowSet.next()) {
			if (rowSet.getString(1).equals("first_name")) {
				user.setFirstName(rowSet.getString(3));
			} else if (rowSet.getString(1).equals("last_name")) {
				user.setLastName(rowSet.getString(3));
			} else if (rowSet.getString(1).equals("email")) {
				user.setEmail(rowSet.getString(3));
			} else if (rowSet.getString(1).equals("accesslevel")) {
				user.setAccessLevel(Integer.parseInt(rowSet.getString(3)));
			}
		}
		return user;

	}

	@Override
	public void blockUser(User user) {
		// TODO Auto-generated method stub

	}

}
