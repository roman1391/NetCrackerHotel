package by.netcracker.hotel.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import by.netcracker.hotel.entities.User;

@Component("UserDAOJdbcTemplateImpl")
public class UserDAOJdbcTemplateImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private static final String SQL_QUERY_ADD_USER = "insert into entity(type_id) values ((select type_id from type where name = 'user')); ";
	private static final String SQL_QUERY_REG_USER = "  "
			+ " insert into value(entity_id, attribute_id, attribute_value) values"
			+ " ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'first_name'), ?),"
			+ " ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'last_name'), ?),"
			+ " ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'login'), ?),"
			+ "  ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'password'), ?),"
			+ "((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'email'), ?);";

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void regUser(User user) {

		jdbcTemplate.update(SQL_QUERY_ADD_USER);
		jdbcTemplate.update(SQL_QUERY_REG_USER, new Object[] { user.getFirstName(), user.getLastName(), user.getLogin(),
				user.getPassword(), user.getEmail() });

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
