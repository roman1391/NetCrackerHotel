package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.events.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
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
import java.util.Locale;

/**
 * Created by slava КПСС on 07.04.17.
 */

@Controller
public class RegistrationController {
    private UserService userService;
    private ApplicationEventPublisher eventPublisher;
    private MessageSource messages;

    @Autowired
    public RegistrationController(UserService userService,ApplicationEventPublisher eventPublisher,
                                  MessageSource messages) {
        this.userService = userService;
        this.eventPublisher = eventPublisher;
        this.messages = messages;
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
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent
                    (registered, request.getLocale(), appUrl));
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

        Locale locale = request.getLocale();

        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return new ModelAndView("badUser?lang="+ locale.getLanguage());
        }

        User user = (User) userService.getByID(verificationToken.getUserID());
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", messageValue);
            return new ModelAndView("badUser?lang="+ locale.getLanguage());
        }

        user.setEnabled(true);
        userService.saveRegisteredUser(user);
        return new ModelAndView("successregitration","success",
                "You are registration successfully.");
    }
}
