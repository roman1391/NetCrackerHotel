package by.netcracker.hotel.enums;


import javax.validation.constraints.NotNull;
import java.util.ResourceBundle;

/**
 * Created by slava on 02.04.17.
 */
public enum SqlQuery {
    ADD, LOGIN, REGISTRATION, GETBYUSERNAME, GETBYEMAIL;

    @NotNull
    public final String getQuery(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("usersqlquery");
        return resourceBundle.getString("sqlquery."+this.name().toLowerCase());
    }
}
