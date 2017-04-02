package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.UserDAO1;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by slava on 02.04.17.
 */

@Component("UserDAOJdbcImpl")
public class UserDAOJdbcImpl implements UserDAO1 {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update(SqlQuery.ADD.getQuery());
        jdbcTemplate.update(SqlQuery.REGISTRATION.getQuery(), new Object[] {user.getFirstName(),
                user.getLastName(), user.getUsername(),
                user.getPassword(), user.getEmail() });
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User update(User type) {
        return null;
    }

    @Override
    public User getByID(Integer ID) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
