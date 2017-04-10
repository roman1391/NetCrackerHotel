package by.netcracker.hotel.controllers;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static by.netcracker.hotel.util.SecurityUtil.getRole;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean save(UserDTO dto) {
        return userService.update(dto);
    }

    @RequestMapping(value = "/log-out", method = RequestMethod.POST)
    public ModelAndView logOut(Authentication authentication) {
        ModelAndView model = new ModelAndView();
        model.addObject("role", getRole(authentication));
        model.setViewName("about");
        return model;
    }

}
