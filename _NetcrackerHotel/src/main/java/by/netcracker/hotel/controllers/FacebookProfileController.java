package by.netcracker.hotel.controllers;

/**
 * Created by slava on 20.04.17.
 */
import javax.inject.Inject;

import by.netcracker.hotel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookProfileController {

    @Autowired
    private ConnectionRepository connectionRepository;

    @RequestMapping(value="/facebook", method=RequestMethod.GET)
    public String home(Model model) {
        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        if (connection == null) {
            return "redirect:/connect/facebook";
        }
        org.springframework.social.facebook.api.User user = connection.getApi().userOperations().getUserProfile();
        model.addAttribute("profile",connection.getApi().userOperations().getUserProfile());
        return "facebook/profile";
    }

}