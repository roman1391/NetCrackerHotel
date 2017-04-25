package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Alexander on 25.04.2017.
 */
@Repository
public class OrderDAOImpl extends JdbcDaoSupport implements OrderDAO {

    private DataSource dataSource;

    @PostConstruct
    private void initialize(){setDataSource(dataSource);}

    @Autowired
    public OrderDAOImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void add(Order order) {
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.ORDER.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_ORDER.getQuery(), order.getUserId(), order.getRoomId(),
                order.getArrivalDate(), order.getLeaveDate(), order.getPayValue(), order.isPaid());
    }

    @Override
    public void deleteByID(Integer integer) {

    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public Order getByID(Integer integer) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    public List<Order> getByUserId(Integer userId){
        return getJdbcTemplate().query(SqlQuery.GET_BY_ID.getQuery(),new Object[]{userId},
                new RowMapperResultSetExtractor<Order>(new OrderMapper()){});
    }
}
