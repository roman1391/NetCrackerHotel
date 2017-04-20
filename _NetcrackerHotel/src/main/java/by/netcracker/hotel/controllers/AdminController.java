package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;

@Controller
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list_of_users", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", new User());
        return "list_of_users";
    }

    @RequestMapping(value = "/add_user_ref", method = RequestMethod.GET)
    public String getAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add_user";
        }
        try {
            User added = (User) userService.addUserByAdmin(user);
        } catch (UsernameExistException e) {
            model.addAttribute("error", "Account with username - " + user.getUsername() + " are exist");
            return "add_user";
        } catch (EmailExistException e) {
            model.addAttribute("error", "Account with email - " + user.getEmail() + " are exist");
            return "add_user";
        }
        model.addAttribute("success", "User - " + user.getUsername() + " was added.");
        return "admin_page";
    }

    @RequestMapping(value = "/edit_form", method = RequestMethod.POST)
    public String getEditForms(@Valid @ModelAttribute("user") User user, Model model) {
        user = (User) userService.getUserByUsername(user.getUsername());
        model.addAttribute("user", user);
        return "user_editing";
    }

    @RequestMapping(value = "/block_user", method = RequestMethod.POST)
    public String blockUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.blockUser(user);
        model.addAttribute("users", userService.getAll());
        return "list_of_users";
    }

    @RequestMapping(value = "/unblock_user", method = RequestMethod.POST)
    public String unblockUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.unblockUser(user);
        model.addAttribute("users", userService.getAll());
        return "list_of_users";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
    public String deleteUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.deleteUserByUsername(user);
        model.addAttribute("success", "User - " + user.getUsername() + " was successfully deleted.");
        return "admin_page";
    }

    @RequestMapping(value = "/list_of_hotels", method = RequestMethod.GET)
    public String getAllHotels(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "list_of_hotels";
    }

}
