package by.netcracker.hotel.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.netcracker.hotel.filter.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.services.OrderService;

/**
 * Created by Alexander on 26.04.2017.
 */
@Controller
@SessionAttributes("searchFilter")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/book_complete", method = RequestMethod.POST)
    public String bookComplete(@ModelAttribute("room") Room room, @ModelAttribute("order") Order order,
                               @ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            order.setArrivalDate(dateFormat.parse(searchFilter.getStartDate())); // временные костыли
            order.setLeaveDate(dateFormat.parse(searchFilter.getEndDate())); // тоже самое
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderService.addOrder(order);// TODO
        // model.addAttribute("ordersDemo", User.getOrder());
        model.addAttribute("order", order);
        return "book_page";
    }

    @RequestMapping(value = "/book_page/{id}", method = RequestMethod.POST)
    public String bookPage(@ModelAttribute("order") Order order, @PathVariable("id") int roomId,
                           @ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        model.addAttribute("order", order);
        model.addAttribute("roomId", roomId);
        return "add_order";
    }

    @RequestMapping(value = "/booked_room", method = RequestMethod.GET)
    public String bookedRooms(@RequestParam String id, Model model) {
        model.addAttribute("orders", orderService.getByUserId(Integer.parseInt(id)));
        return "bookedRooms";
    }

    @RequestMapping(value = "/delete_order/{id}", method = RequestMethod.POST)
    public String deleteOrder(@ModelAttribute("currentUser") User user, @PathVariable("id") int orderId, Model model) {

        orderService.deleteByOrderId(orderId);
        return bookedRooms(String.valueOf(user.getId()), model);
    }
}
