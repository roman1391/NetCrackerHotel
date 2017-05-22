package by.netcracker.hotel.dao.constants;

/**
 * Created by slava on 09.04.17.
 */
public enum TypeName {
    USER, HOTEL, ROOM, ORDER, TIME_TABLE, PHOTOS, VERIFICATION_TOKEN, REVIEW;

    public final int getType() {
        return this.ordinal() + 1;
    }
}
