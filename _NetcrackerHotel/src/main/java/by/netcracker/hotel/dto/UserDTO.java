package by.netcracker.hotel.dto;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;

/**
 * Created by Alexander on 06.04.2017.
 */
public class UserDTO implements DTO {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private ROLE authority;
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ROLE getAuthority() {
        return authority;
    }

    public void setAuthority(ROLE authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public User toObject() {
        User user = new User();
        user.setId(getId());
        user.setUsername(getUsername());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setEmail(getEmail());
        if (getPassword() != null && !getPassword().equals("0")) {
            user.setPassword(getPassword());
        }
        user.setEnabled(getEnabled());
        user.setAuthority(getAuthority());
        user.setAvatar(getAvatar());
        return user;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatarFile) {
        this.avatar = avatarFile;
    }
}
