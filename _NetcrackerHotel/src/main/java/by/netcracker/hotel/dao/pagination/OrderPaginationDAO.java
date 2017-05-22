package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.constants.TypeName;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.pagination.OrderSearchParam;
import by.netcracker.hotel.mappers.OrderMapper;

@Repository
public class OrderPaginationDAO extends AbstractPaginationJdbcDAO<Order, OrderSearchParam> {

    @Autowired
    private DataSource dataSource;

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
        mapFilters.put("ord_user", pparam.getUsername());
        mapFilters.put("ord_hotel", pparam.getHotelname());
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, OrderSearchParam pparam) {
        boToDbMap.put("arrival", "arrival_date");
        boToDbMap.put("leave", "leave_date");
        boToDbMap.put("username", "ord_user");
        boToDbMap.put("hotel", "ord_hotel");
    }

}
