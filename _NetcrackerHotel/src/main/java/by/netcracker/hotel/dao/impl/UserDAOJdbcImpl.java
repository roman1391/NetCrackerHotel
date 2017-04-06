package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by slava on 02.04.17.
 */

@Component("UserDAOJdbcImpl")
public class UserDAOJdbcImpl extends JdbcDaoSupport implements UserDAO {
    @Autowired
    private DataSource dataSource;
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public void add(User user) {
       getJdbcTemplate().update(SqlQuery.ADD.getQuery());
       getJdbcTemplate().update(SqlQuery.REGISTRATION.getQuery(),
                   new Object[]{user.getFirstName(), user.getLastName(),
                           user.getUsername(), user.getPassword(), user.getEmail()});
    }

    @Override
    public void delete(Integer id){

    }

    @Override
    public List<User> getAll() {

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
        try {
            return (User) getJdbcTemplate().queryForObject(SqlQuery.GETBYUSERNAME.getQuery(),
                    new Object[]{username}, new UserMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public User getByEmail(String email) {
        try {
            return (User) getJdbcTemplate().queryForObject(SqlQuery.GETBYEMAIL.getQuery(),
                    new Object[]{email}, new UserMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
