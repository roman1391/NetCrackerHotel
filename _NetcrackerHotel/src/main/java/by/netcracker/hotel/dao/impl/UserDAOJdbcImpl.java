package by.netcracker.hotel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import by.netcracker.hotel.dao.constant.TypeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.constant.ColumnName;
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
	public void add(User user) throws SQLException {
		getJdbcTemplate().update(SqlQuery.ADD.getQuery());
		getJdbcTemplate().update(SqlQuery.REGISTRATION.getQuery(), user.getFirstName(),
				user.getLastName(), user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail());
	}

	@Override
	public void deleteByID(Integer id) throws SQLException {
        getJdbcTemplate().update(SqlQuery.DELETEBYID.getQuery(),
				                new Object[]{ColumnName.USER_ID});
	}

	@Override
	public List<User> getAll() {
		List<User> list = getJdbcTemplate().query(SqlQuery.GETALL.getQuery(),
				     new Object[]{TypeName.UserType},new UserMapper());
		return null;
	}

	@Override
	public User update(User type) throws SQLException {

		return null;
	}

	@Override
	public User getByID(Integer id){
		try {
			return getJdbcTemplate().queryForObject(SqlQuery.GETBYID.getQuery(), new Object[] { id },
					new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User getByUsername(String username) throws SQLException {
		try {
			return getJdbcTemplate().queryForObject(SqlQuery.GETBY.getQuery(),
					new Object[] { ColumnName.USER_USERNAME, username }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void deleteByUsername(String username) throws SQLException {
		getJdbcTemplate().update(SqlQuery.DELETEBY.getQuery(),
				new Object[]{ColumnName.USER_USERNAME,username});
	}

	@Override
	public User getByEmail(String email) throws SQLException {
		try {
			return getJdbcTemplate().queryForObject(SqlQuery.GETBY.getQuery(),
					new Object[] { ColumnName.USER_EMAIL, email }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
