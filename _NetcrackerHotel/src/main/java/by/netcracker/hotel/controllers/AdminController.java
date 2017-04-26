package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/edit_form/{username}", method = RequestMethod.GET)
    public String getEditForms(@Valid @PathVariable("username") String username, Model model) {
        User user = userService.getUserByUsername(username);
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

}
