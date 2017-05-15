package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.OrderService;
import by.netcracker.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Alexander on 26.04.2017.
 */
@Controller
@SessionAttributes("searchFilter")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;


    @RequestMapping(value = "/book_complete", method = RequestMethod.POST)
    public String bookComplete(@ModelAttribute("room") Room room, @ModelAttribute("order") Order order,
                               @ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        SimpleDateFormat dateFormatParse = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (!searchFilter.getStartDate().equals("") && !searchFilter.getEndDate().equals("")) {
            try {
                order.setArrivalDate(dateFormatParse.parse(searchFilter.getStartDate()));
                order.setLeaveDate(dateFormatParse.parse(searchFilter.getEndDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (roomService.isRoomFree(order.getRoomId(), new SearchFilter(dateFormat.format(order.getArrivalDate()),
                dateFormat.format(order.getLeaveDate())))) {
            orderService.addOrder(order);// TODO
            model.addAttribute("order", order);
        } else{
            model.addAttribute("message","error");
        }
        return "book_page";
    }

    @RequestMapping(value = "/book_page/{id}", method = RequestMethod.POST)
    public String bookPage(@ModelAttribute("order") Order order, @PathVariable("id") int roomId,
                           @ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        order.setPayValue(roomService.getByID(roomId).getCost());
        model.addAttribute("order", order);
        model.addAttribute("roomId", roomId);
        return "add_order";
    }

    @RequestMapping(value = "/booked_room", method = RequestMethod.GET)
    public String bookedRooms(@RequestParam String id, Model model) {
        model.addAttribute("orders", orderService.getByUserId(Integer.parseInt(id)));
        return "bookedRooms";
    }

    @RequestMapping(value = "/delete_order/{orderId}", method = RequestMethod.POST)
    public String deleteOrder(@ModelAttribute("user") User user, @PathVariable("orderId") int orderId, Model model) {

        orderService.deleteByOrderId(orderId);
        return bookedRooms(String.valueOf(user.getId()), model);
    }

    @RequestMapping(value = "/edit_order/{orderId}", method = RequestMethod.GET)
    public String editOrder(@PathVariable("orderId") int orderId, Model model) {
        Order order = orderService.getByID(orderId);
        model.addAttribute("order", order);
        model.addAttribute("activeOrder", new Order());
        model.addAttribute("filter", new SearchFilter());
        return "edit_order";
    }

    @RequestMapping(value = "/change_order", method = RequestMethod.POST)
    public String applyOrder(@ModelAttribute("activeOrder") Order order, Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SearchFilter searchFilter = new SearchFilter(dateFormat.format(order.getArrivalDate()),
                dateFormat.format(order.getLeaveDate()));

        if (roomService.isRoomFree(order.getRoomId(), searchFilter)) {
            orderService.update(order.getId(), searchFilter);
            model.addAttribute("orders", orderService.getByUserId(order.getUserId()));
            model.addAttribute("message", "success");
        }
        else {
            model.addAttribute("orders", orderService.getByUserId(order.getUserId()));
            model.addAttribute("message", "error");
        }
        return "bookedRooms";
    }
}
