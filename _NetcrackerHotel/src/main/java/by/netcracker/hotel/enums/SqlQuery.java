package by.netcracker.hotel.enums;

import java.util.ResourceBundle;

import javax.validation.constraints.NotNull;

/**
 * Created by slava on 02.04.17.
 */
public enum SqlQuery {
	ADD, LOGIN, REGISTRATION, GETBY, GETBYID, GETALL, SEARCH_HOTEL, GET_PLACES, GET_ALL_ENTITIES_BY_TYPE;

	@NotNull
	public final String getQuery() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("usersqlquery");
		return resourceBundle.getString("sqlquery." + this.name().toLowerCase());
	}
}
