package by.netcracker.hotel.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.OrderMapper;

/**
 * Created by Alexander on 25.04.2017.
 */
@Repository
public class OrderDAOImpl extends JdbcDaoSupport implements OrderDAO {

    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public OrderDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Order order) {
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.ORDER.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_ORDER.getQuery(), order.getUserId(), order.getRoomId(),
            order.getUsername(), order.getHotelname(), order.getArrivalDate(), order.getLeaveDate(),
            order.getPayValue(), order.isPaid(), order.getFirstName(), order.getLastName());
    }

    @Override
    public void deleteByID(Integer id) {
        getJdbcTemplate().update(SqlQuery.DELETE_BY_ID.getQuery(), id);
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public Order getByID(Integer id) {
        try {
            return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    public List<Order> getByUserId(Integer userId) {
        return getJdbcTemplate().query(SqlQuery.GET_BY_ID.getQuery(), new Object[] { userId },
            new RowMapperResultSetExtractor<Order>(new OrderMapper()) {
            });
    }

    @Override
    public List<Order> getByUserId(int userId) {
        return getJdbcTemplate().query(SqlQuery.GET_BY.getQuery(),
            new Object[] { ColumnName.ORDER_USER_ID.toLowerCase(), userId },
            new RowMapperResultSetExtractor<Order>(new OrderMapper()) {
            });
    }
}
