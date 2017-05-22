package by.netcracker.hotel.entities.entityBuilder;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;

/**
 * Created by slava on 09.04.17.
 */
public class EntityBuilder {

    public static User buildUser(String firstName, String lastName, String username, String password, String email,
        boolean enabled, ROLE authority) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setEnabled(enabled);
        user.setAuthority(authority);
        return user;
    }
}
