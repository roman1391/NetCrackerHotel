package by.netcracker.hotel.controllers;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UserNotFoundException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

/**
 * @author Yauheni Shopik
 * @since 4/7/2017
 */
@Controller
public class UserController {

    @Autowired
    private WebApplicationContext context;

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String save(UserDTO dto) {
        System.out.println(dto);
        return "true";
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute("user") User user, Model model) {

        UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
        try {
            userService.loginUser(user);
        } catch (UserNotFoundException e) {
            return "error";
        }
        return "successregistration";
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
        try {
            userService.registerUser(user);
        } catch (UsernameExistException e){
            model.addAttribute("error","Account with username - "+user.getUsername()+" are exist");
            return "registration";
        } catch (EmailExistException e){
            model.addAttribute("error","Account with email - "+user.getEmail()+" are exist");
            return "registration";
        }

        return "successregistration";
    }
}
