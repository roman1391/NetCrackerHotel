package by.netcracker.hotel.handlers;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.events.OnRegistrationCompleteEvent;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by slava on 15.04.17.
 */
@Component("RegistrationListener")
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    private UserService service;
    private JavaMailSender mailSender;

    @Autowired
    public RegistrationListener(UserService service,JavaMailSender mailSender){
        this.service = service;
        this.mailSender = mailSender;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user.getId(), token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/regitrationConfirm?token=" + token;
        String message = "Confirm";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " rn " + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}

