package by.netcracker.hotel.controllers.pagination;

import java.util.Map;

import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.paginationspring.controller.PaginationControllerAbstract;

import by.netcracker.hotel.entities.pagination.OrderSearchParam;
import by.netcracker.hotel.services.OrderService;
import by.netcracker.hotel.services.impl.pagination.OrderPaginationService;

@Controller
@RequestMapping("/admin")
public class OrderPaginationController extends PaginationControllerAbstract<OrderSearchParam> {
    private static Logger log = Logger.getLogger(OrderPaginationController.class);

    private OrderPaginationService orderPaginationService;
    private OrderService orderService;
    private HotelService hotelService;
    private UserService userService;

    public OrderPaginationController() {
        setOptionWidth(750);
        setDefaultRecordPerPage(10);
        setDefaultSortAscDesc("d");
        setPageLink("/admin/pagination/list_of_orders_ajax");
        setAjax(true);
    }

    @Autowired
    public void setPaginationService(OrderPaginationService orderPaginationService, OrderService orderService,
                                     HotelService hotelService, UserService userService) {
        super.setPaginationService(orderPaginationService);
        this.orderPaginationService = orderPaginationService;
        this.orderService = orderService;
        this.hotelService = hotelService;
        this.userService = userService;
    }

    @RequestMapping(value = "/list_of_orders", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) OrderSearchParam pparam, Model model) throws Exception {
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        model.addAttribute("hotels", hotelService.getHotelNames());
        model.addAttribute("usernames", userService.getUsernames());
        return "admin/pagination/list_of_orders";
    }

    @RequestMapping(value = "/list_of_orders/{num}", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) OrderSearchParam pparam, @PathVariable("num") int num, Model model)
        throws Exception {
        setDefaultRecordPerPage(num);
        orderPaginationService.setPageNum(num);
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        return "admin/pagination/list_of_orders";
    }

    @RequestMapping(value = "pagination/list_of_orders_ajax", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineAjaxJsp(@ModelAttribute(PPARAM) OrderSearchParam pparam,
        @RequestParam(value = BUTTON_ACTION, required = false) String buttonAction, Model model) throws Exception {
        orderPaginationService.deleteButtonAction(pparam, buttonAction);
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        return "admin/pagination/list_of_orders_ajax";
    }
}