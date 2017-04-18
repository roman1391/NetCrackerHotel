package by.netcracker.hotel.entities;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.enums.ROLE;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User implements BusinessObject {

    public static User getUser() {
        User user = new User();
        user.setId(1);
        user.setEmail("sdfsdf@df.ru");
        user.setFirstName("FirstName");
        user.setLastName("dsfsdf");
        user.setAccessLevel(1);
        return user;
    }

    private int id;

    @Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "First name must be alphanumeric with no spaces")
    private String firstName;

    @Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Last name must be alphanumeric with no spaces")
    private String lastName;

    @Size(min = 4, message = "Username size is min 4 symbols")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login must be alphanumeric with no spaces")
    private String username;

    @Size(min = 6, message = "Password is min 6 and max 15 symbols ")
    private String password;

/*    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email address")*/
    private String email;

    private int accessLevel;

    private boolean enabled;

    private ROLE authority;

    private String avatar;

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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return getId() == user.getId() && getAccessLevel() == user.getAccessLevel()
                && Objects.equals(getFirstName(), user.getFirstName())
                && Objects.equals(getLastName(), user.getLastName())
                && Objects.equals(getUsername(), user.getUsername())
                && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(),
                getAccessLevel());
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        dto.setId(getId());
        dto.setUsername(getUsername());
        dto.setFirstName(getFirstName());
        dto.setLastName(getLastName());
        dto.setEmail(getEmail());
        dto.setAuthority(getAuthority());
        dto.setEnabled(getEnabled());
        dto.setAccessLevel(getAccessLevel());
        dto.setAvatar(getAvatar());
        return dto;
    }

}
