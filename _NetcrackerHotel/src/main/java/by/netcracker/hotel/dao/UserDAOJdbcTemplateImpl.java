package by.netcracker.hotel.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
			+ " ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'password'), ?),"
			+ " ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'email'), ?),"
			+ " ((select max(entity_id) from entity), (select attribute_id from attribute where attribute_name = 'accesslevel'), 2);";
	private static final String SQL_QUERY_LOGIN_USER = "select attribute_name, datatype, attribute_value from value inner join attribute on value.attribute_id=attribute.attribute_id "
			+ "where entity_id=(select entity_id from " + "(select v.entity_id from value v "
			+ "inner join attribute attr on v.attribute_id = attr.attribute_id "
			+ "where attr.attribute_name = 'login' and v.attribute_value= ? ) aaa " + "where entity_id in "
			+ "(select v.entity_id from value v " + "inner join attribute attr on v.attribute_id = attr.attribute_id "
			+ "where attr.attribute_name = 'password' and v.attribute_value= ? ));";

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
	public User loginUser(User user) {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SQL_QUERY_LOGIN_USER,
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
