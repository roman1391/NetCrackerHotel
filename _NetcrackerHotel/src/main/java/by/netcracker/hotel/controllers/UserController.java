package by.netcracker.hotel.controllers;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.events.ForgotPasswordEvent;
import by.netcracker.hotel.exceptions.UserNotFoundException;
import by.netcracker.hotel.services.OrderService;
import by.netcracker.hotel.services.UserService;
import by.netcracker.hotel.util.CloudinaryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import java.util.Arrays;
import java.util.Date;

import static by.netcracker.hotel.util.CloudinaryUtil.saveFileToCloud;

@Controller
public class UserController {

    private ApplicationEventPublisher eventPublisher;
    private final long TOKEN_LIFE_TIME = 86400000;

    @Autowired
    public UserController(ServletContext context,ApplicationEventPublisher eventPublisher) {
        CloudinaryUtil.UPLOADED_FOLDER = context.getRealPath("/resources/img/");
        this.eventPublisher = eventPublisher;
    }

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String save(@ModelAttribute("currentUser") User dto, @RequestParam("file") MultipartFile file) {
        dto.setAvatar(saveFileToCloud(file));
        userService.update(dto);
        return "profile";
    }

    @RequestMapping(value = "/log-out", method = RequestMethod.POST)
    public ModelAndView logOut() {
        ModelAndView model = new ModelAndView();
        model.addObject("role", ROLE.GUEST);
        model.setViewName("about");
        return model;
    }

    @RequestMapping(value = "/forgot_password",method = RequestMethod.GET)
    public String forgotPassword(){
        return "forgot_password";
    }

    @RequestMapping(value = "/forgot_password",method = RequestMethod.POST)
    public String forgotPassword(@RequestParam String email,WebRequest request, Model model){

        User user = userService.getUserByEmail(email);
        if(user==null) {
            model.addAttribute("error","Account with this email didn't exist.");
            return "forgot_password";
        } else {
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new ForgotPasswordEvent(user, appUrl));
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user, null,
                    Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
            SecurityContextHolder.getContext().setAuthentication(auth);
            model.addAttribute("message","We send you verification email.");
            return "forgot_password";
        }

    }

    @RequestMapping(value = "/reset_password",method = RequestMethod.GET)
    public ModelAndView resetPassword(WebRequest request, Model model, @RequestParam("token") String token){
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            return new ModelAndView("reset_password","error",
                    "Verification token not found. Try reset password again.");
        } else {
            return new ModelAndView("reset_password");
        }
    }


    @RequestMapping(value = "/reset_password",method = RequestMethod.POST)
    public ModelAndView resetPassword(@RequestParam String password,WebRequest request, Model model){
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         userService.changeUserPassword(user,password);
         return new ModelAndView("login_page","message",
                 "You complete reset password");
    }
}
