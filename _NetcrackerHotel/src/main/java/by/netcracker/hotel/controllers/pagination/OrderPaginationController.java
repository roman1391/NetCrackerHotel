package by.netcracker.hotel.controllers.pagination;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.paginationspring.controller.PaginationControllerAbstract;

import by.netcracker.hotel.entities.pagination.OrderSearchParam;
import by.netcracker.hotel.services.OrderService;
import by.netcracker.hotel.services.impl.pagination.OrderPaginationService;

@Controller
public class OrderPaginationController extends PaginationControllerAbstract<OrderSearchParam> {
    private static Logger log = Logger.getLogger(OrderPaginationController.class);

    private OrderPaginationService orderPaginationService;
    private OrderService orderService;

    public OrderPaginationController() {
        setOptionDisplayCheckbox(true);
        setOptionDisplaySerialNo(true);
        setOptionWidth(750);
        setDefaultRecordPerPage(10);
        setDefaultSortAscDesc("d");
        setPageLink("/pagination/list_of_orders_ajax");
        setAjax(true);
    }

    @Autowired
    public void setPaginationService(OrderPaginationService orderPaginationService, OrderService orderService) {
        super.setPaginationService(orderPaginationService);
        this.orderPaginationService = orderPaginationService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/list_of_orders", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) OrderSearchParam pparam, Model model) throws Exception {
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        return "pagination/list_of_orders";
    }

    @RequestMapping(value = "pagination/list_of_orders_ajax", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineAjaxJsp(@ModelAttribute(PPARAM) OrderSearchParam pparam,
        @RequestParam(value = BUTTON_ACTION, required = false) String buttonAction, Model model) throws Exception {
        orderPaginationService.deleteButtonAction(pparam, buttonAction);
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        return "pagination/list_of_orders_ajax";
    }
}