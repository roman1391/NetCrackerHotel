package by.netcracker.hotel.enums;

import java.util.ResourceBundle;

import javax.validation.constraints.NotNull;

/**
 * Created by slava on 02.04.17.
 */
public enum SqlQuery {
    ADD_ENTITY_ID, ADD_USER, GET_BY, GET_BY_ID, ADD_REVIEW,
    GET_ALL, SEARCH_HOTEL, GET_PLACES, DELETE_BY_ID, DELETE_BY,
    UPDATE, ADD_TOKEN, ADD_HOTEL, ADD_PHOTO, GET_PHOTOS_FOR_HOTEL,
    GET_MAIN_PHOTO_FOR_HOTEL, SET_MAIN_PHOTO_FOR_HOTEL, CHECK_REVIEW;

    @NotNull
    public final String getQuery() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("usersqlquery");
        return resourceBundle.getString("sqlquery." + this.name().toLowerCase());
    }
}
