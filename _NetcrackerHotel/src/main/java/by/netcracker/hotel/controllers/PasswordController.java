package by.netcracker.hotel.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.events.ForgotPasswordEvent;
import by.netcracker.hotel.services.UserService;

/**
 * Created by slava on 02.05.17.
 */
@Controller
@RequestScope
public class PasswordController {
    private UserService userService;
    private ApplicationEventPublisher eventPublisher;
    private final long TOKEN_LIFE_TIME = 86400000;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PasswordController(UserService userService, ApplicationEventPublisher eventPublisher,
        BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.eventPublisher = eventPublisher;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/forgot_password", method = RequestMethod.GET)
    public String forgotPassword() {
        return "forgot_password";
    }

    @RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
    public String forgotPassword(@RequestParam String email, WebRequest request, Model model) {

        User user = userService.getUserByEmail(email);
        if (user == null) {
            model.addAttribute("error", "Account with this email didn't exist.");
            return "forgot_password";
        } else {
            String autority = user.getAuthority().name();
            if(autority.equals("VKONTAKTE_USER") || autority.equals("TWITTER_USER") ||
                    autority.equals("FACEBOOK_USER")){
               model.addAttribute("error","Account create by " +
                       "social provider can't change password");
               return "forgot_password";
            }
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new ForgotPasswordEvent(user, appUrl));
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null,
                Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
            SecurityContextHolder.getContext().setAuthentication(auth);
            model.addAttribute("message", "We send you verification email.");
            return "forgot_password";
        }

    }

    @RequestMapping(value = "/reset_password", method = RequestMethod.GET)
    public ModelAndView resetPassword(WebRequest request, Model model, @RequestParam("token") String token) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            return new ModelAndView("reset_password", "error",
                "Verification token not found. Try reset password again.");
        } else {
            userService.deleteVerificationToken(verificationToken.getId());
            return new ModelAndView("reset_password");
        }
    }

    @RequestMapping(value = "/reset_password", method = RequestMethod.POST)
    public ModelAndView resetPassword(@RequestParam String password, WebRequest request, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.changeUserPassword(user, password);
        return new ModelAndView("login_page", "message", "You complete reset password");
    }

    @RequestMapping(value = "/change_password", method = RequestMethod.GET)
    public String changePassword() {
        return "change_password";
    }

    @RequestMapping(value = "/change_password", method = RequestMethod.POST)
    public String changePassword(@RequestParam("oldPassword") String oldPassword,
        @RequestParam("newPassword") String newPassword, WebRequest request, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(username);
        if (bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            userService.changeUserPassword(user, newPassword);
            model.addAttribute("message", "You successfully change password.");
            return "profile";
        } else {
            model.addAttribute("error", "Old password isn't confirm");
            return "change_password";
        }
    }
}
