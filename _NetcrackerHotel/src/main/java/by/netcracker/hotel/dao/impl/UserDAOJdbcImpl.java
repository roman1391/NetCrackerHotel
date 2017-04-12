package by.netcracker.hotel.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.UserMapper;

/**
 * Created by slava on 02.04.17.
 */

@Component("UserDAOJdbcImpl")
public class UserDAOJdbcImpl extends JdbcDaoSupport implements UserDAO {
	private DataSource dataSource;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Autowired
	public UserDAOJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(User user) {
		getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.USER.name().toLowerCase());
		getJdbcTemplate().update(SqlQuery.ADD_USER.getQuery(), user.getFirstName(), user.getLastName(),
				user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail());

	}

	@Override
	public void deleteByID(Integer id) {
		getJdbcTemplate().update(SqlQuery.DELETE_BY_ID.getQuery(), id);
	}

	@Override
	public List<User> getAll() {
		return getJdbcTemplate().query(SqlQuery.GET_ALL.getQuery(), new Object[] { TypeName.USER.getType() },
				new RowMapperResultSetExtractor<User>(new UserMapper()) {
				});
	}

	@Override
	public void update(User user) {
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getFirstName(), ColumnName.USER_FIRST_NAME,
				user.getId());
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getLastName(), ColumnName.USER_LAST_NAME,
				user.getId());
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getUsername(), ColumnName.USER_USERNAME,
				user.getId());
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getEmail(), ColumnName.USER_EMAIL, user.getId());
//		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), passwordEncoder.encode(user.getPassword()),
//				ColumnName.USER_PASSWORD, user.getId());
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getAccessLevel(), ColumnName.USER_ACCESS_LEVEL,
				user.getId());
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getAuthority(), ColumnName.USER_AUTHORITY,
				user.getId());
		getJdbcTemplate().update(SqlQuery.UPDATE.getQuery(), user.getEnabled(), ColumnName.USER_ENABLED, user.getId());
	}

	@Override
	public User getByID(Integer id) {
		try {
			return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
					new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User getByUsername(String username) {
		try {
			User user = (User) getJdbcTemplate().queryForObject(SqlQuery.GET_BY.getQuery(),
					new Object[] { ColumnName.USER_USERNAME, username }, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void deleteByUsername(String username) {
		getJdbcTemplate().update(SqlQuery.DELETE_BY.getQuery(), ColumnName.USER_USERNAME, username);
	}

	@Override
	public void deleteByEmail(String email) {
		getJdbcTemplate().update(SqlQuery.DELETE_BY.getQuery(), ColumnName.USER_EMAIL, email);
	}

	@Override
	public void updateByFields(String field, String value) {

	}

	@Override
	public User getByEmail(String email) {
		try {
			return (User) getJdbcTemplate().queryForObject(SqlQuery.GET_BY.getQuery(),
					new Object[] { ColumnName.USER_EMAIL, email }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
