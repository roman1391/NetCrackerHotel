package by.netcracker.hotel.handlers;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.events.ForgotPasswordEvent;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by slava on 02.05.17.
 */
@Component("ForgotPasswordListener")
public class ForgotPasswordListener implements ApplicationListener<ForgotPasswordEvent> {
    private UserService service;
    private JavaMailSender mailSender;

    @Autowired
    public ForgotPasswordListener(UserService service,JavaMailSender mailSender){
        this.service = service;
        this.mailSender = mailSender;
    }

    @Override
    public void onApplicationEvent(ForgotPasswordEvent forgotPasswordEvent) {
         this.forgotPasswordConfirm(forgotPasswordEvent);
    }

    private void forgotPasswordConfirm(ForgotPasswordEvent event){
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user.getId(), token);

        String recipientAddress = user.getEmail();
        String subject = "Password reset";
        String confirmationUrl
                = event.getAppUrl() + "/reset_password?token=" + token;
        String message = "Reset";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " rn " + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }

}
