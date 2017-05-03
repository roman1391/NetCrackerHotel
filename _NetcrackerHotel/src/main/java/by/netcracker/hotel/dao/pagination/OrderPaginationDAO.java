package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.pagination.OrderSearchParam;
import by.netcracker.hotel.mapper.OrderMapper;

@Repository
public class OrderPaginationDAO extends AbstractPaginationJdbcDAO<Order, OrderSearchParam> {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDAO userDAO;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public OrderPaginationDAO(DataSource dataSource) {
        super(dataSource);
        setRowMapper(new OrderMapper());
        setTypeId(TypeName.ORDER.getType());
        setTypeName("order");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, OrderSearchParam pparam) {
//        mapFilters.put("user_id", String.valueOf(userDAO.getByUsername(pparam.getUsername()).getId()));
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, OrderSearchParam pparam) {

    }

}
