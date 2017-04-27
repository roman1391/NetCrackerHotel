package by.netcracker.hotel.social;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by slava on 27.04.17.
 */
@Component("FacebookConnectionSignUp")
public class FacebookConnectionSignUp implements ConnectionSignUp {


    @Autowired
    private UserService userService;

    @Override
    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        User user = new User();
        user.setEmail(profile.getEmail());
        user.setUsername(profile.getId());
        user.setPassword(UUID.randomUUID().toString());
        user.setFirstName(profile.getFirstName());
        user.setLastName(profile.getLastName());
        try {
            userService.addUserByAdmin(user);
        } catch (UsernameExistException | EmailExistException e){
            e.printStackTrace();
        }
        return user.getUsername();
    }
}
