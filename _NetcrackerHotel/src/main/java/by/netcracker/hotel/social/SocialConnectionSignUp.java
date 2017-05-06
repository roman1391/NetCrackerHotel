package by.netcracker.hotel.social;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

/**
 * Created by slava on 27.04.17.
 */
@Component("SocialConnectionSignUp")
@RequestScope
public class SocialConnectionSignUp implements ConnectionSignUp {


    @Autowired
    private UserService userService;

    @Override
    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        String provider = connection.getKey().getProviderId();
        User user = new User();
        switch (provider) {
            case "vkontakte":{
                Connection<VKontakte> conVK = (Connection<VKontakte>) connection;
                user.setEmail(conVK.getApi().getEmail());
                user.setUsername(profile.getId());
                user.setPassword(UUID.randomUUID().toString());
                user.setFirstName(profile.getFirstName());
                user.setLastName(profile.getLastName());
                user.setAuthority(ROLE.VKONTAKTE_USER);
                break;
            }
            case "facebook": {
                user.setEmail(profile.getEmail());
                user.setUsername(profile.getId());
                user.setPassword(UUID.randomUUID().toString());
                user.setFirstName(profile.getFirstName());
                user.setLastName(profile.getLastName());
                user.setAuthority(ROLE.FACEBOOK_USER);
                break;
            }
            case "twitter":{
                user.setEmail("none");
                user.setUsername(profile.getUsername());
                user.setPassword(UUID.randomUUID().toString());
                user.setFirstName(profile.getFirstName());
                user.setLastName(profile.getLastName());
                user.setAuthority(ROLE.TWITTER_USER);
                break;
            }
        }
        try {
            userService.addEnabledUser(user);
        } catch (UsernameExistException | EmailExistException e){
            e.printStackTrace();
        }
        return user.getUsername();
    }
}
