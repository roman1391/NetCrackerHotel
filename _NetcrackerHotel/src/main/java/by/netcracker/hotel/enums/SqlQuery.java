package by.netcracker.hotel.enums;


import javax.validation.constraints.NotNull;
import java.util.ResourceBundle;

/**
 * Created by slava on 02.04.17.
 */
public enum SqlQuery {
    ADD_ENTITY_ID,ADD_USER, GET_BY, GET_BY_ID,
    GET_ALL, SEARCH_HOTEL, GET_PLACES, DELETE_BY_ID, DELETE_BY,UPDATE,ADD_TOKEN, ADD_HOTEL;

    @NotNull
    public final String getQuery(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("usersqlquery");
        return resourceBundle.getString("sqlquery."+this.name().toLowerCase());
    }
}
