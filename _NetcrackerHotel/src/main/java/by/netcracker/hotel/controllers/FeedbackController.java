package by.netcracker.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;


/**
 * Created by slava on 15.05.17.
 */
@Controller
@RequestScope
public class FeedbackController {

    @Autowired
    private MailSender mailSender;

    private final String recipient = "netcrackerhotel@gmail.com";

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String feedbackGet(){
        return "feedback";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public String feedbackPost(@RequestParam("sender") String sender,
                               @RequestParam("subject") String subject,
                               @RequestParam("message") String message, Model model){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(sender);
        email.setTo(recipient);
        email.setSubject(subject);
        email.setText(message);
        try {
            mailSender.send(email);
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error","Sending email error.");
            return "feedback";
        }
        model.addAttribute("success","Your email send successfully");
        return "feedback";
    }
}
