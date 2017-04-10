package by.netcracker.hotel.dao.constant;

/**
 * Created by slava on 11.04.17.
 */
public enum UserRole {
    GUEST,USER, ADMIN;

    public final String getRole(){
        return this.name();
    }
}
