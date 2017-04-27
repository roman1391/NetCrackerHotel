package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.events.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by slava КПСС on 07.04.17.
 */

@Controller
public class RegistrationController {
    private UserService userService;
    private ApplicationEventPublisher eventPublisher;
    private final long TOKEN_LIFE_TIME = 86400000;

    @Autowired
    public RegistrationController(UserService userService,
                                  ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,
                               BindingResult bindingResult, WebRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            User registered = (User) userService.registerUser(user);
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, appUrl));
        } catch (UsernameExistException e) {
            model.addAttribute("error", "Account with username - " + user.getUsername() + " are exist");
            return "registration";
        } catch (EmailExistException e) {
            model.addAttribute("error", "Account with email - " + user.getEmail() + " are exist");
            return "registration";
        }
        return "compliteregistration";
    }

    @RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration
            (WebRequest request, Model model, @RequestParam("token") String token) {

        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            return new ModelAndView("badUser","message", "Token not found");
        }

        User user = (User) userService.getByVerificationToken(verificationToken.getToken());
        Calendar cal = Calendar.getInstance();


        if ((cal.getTime().getTime() - verificationToken.getDate().getTime()) >= TOKEN_LIFE_TIME) {
            userService.deleteVerificationToken(verificationToken.getId());
            userService.deleteUserByUsername(user.getUsername());
            return new ModelAndView("badUser","message", "Invalid time");
        }

        user.setEnabled(true);
        userService.saveRegisteredUser(user);
        userService.deleteVerificationToken(verificationToken.getId());
        return new ModelAndView("successregistration","success",
                "You are registration successfully.");
    }
}
