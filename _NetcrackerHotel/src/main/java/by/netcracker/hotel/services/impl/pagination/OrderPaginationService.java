package by.netcracker.hotel.services.impl.pagination;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paginationspring.bo.BoPaginationColumn;
import com.github.paginationspring.dao.PaginationDao;
import com.github.paginationspring.service.PaginationServiceAbstract;

import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.dao.pagination.OrderPaginationDAO;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.pagination.OrderRow;
import by.netcracker.hotel.entities.pagination.OrderSearchParam;

@Service
public class OrderPaginationService extends PaginationServiceAbstract<OrderSearchParam, OrderRow, Order> {

    private static Logger log = Logger.getLogger(OrderPaginationService.class);

    @SuppressWarnings("unused")
    private PaginationDao<Order, OrderSearchParam> orderPaginationDAO;
    private OrderDAO orderDAO;

    @Autowired
    public void setPaginationDao(OrderPaginationDAO orderPaginationDAO, OrderDAO orderDAO) {
        super.setPaginationDao(orderPaginationDAO);
        this.orderPaginationDAO = orderPaginationDAO;
        this.orderDAO = orderDAO;

    }

    @Override
    public void assignColumnsDefinition(List<BoPaginationColumn> columns) throws Exception {
        log.debug("setting columns def.");

        BoPaginationColumn col = null;

        col = new BoPaginationColumn();
        col.setColumnName("Username");
        col.setOrderColumns("username");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Hotel");
        col.setOrderColumns("hotelname");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Arrival");
        col.setColumnName("arrival");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Leave");
        col.setColumnName("leave");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Order");
        col.setWidth(30);
        columns.add(col);
    }

    @Override
    protected OrderRow assignDataToBo(Order order) throws Exception {
        OrderRow bo = new OrderRow();
        bo.setOrderId(order.getId());
        bo.setHotelname(order.getHotelname());
        bo.setUsername(order.getUsername());
        bo.setArrivalDate(order.getArrivalDate().toString());
        bo.setLeaveDate(order.getLeaveDate().toString());
        return bo;
    }

    public void deleteButtonAction(OrderSearchParam pparam, String buttonAction) {
        if (buttonAction != null && buttonAction.equals("deleteButton")) {
            for (String id : pparam.getSelectedIds()) {
                orderDAO.deleteByID(Integer.parseInt(id));
            }
        }
    }
}
