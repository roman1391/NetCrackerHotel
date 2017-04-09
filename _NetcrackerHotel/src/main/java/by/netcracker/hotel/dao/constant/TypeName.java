package by.netcracker.hotel.dao.constant;

/**
 * Created by slava on 09.04.17.
 */
public enum TypeName {
    USER,HOTEL,ROOM,ORDER,TIME_TABLE,PHOTOS;

    public final int getType(){
        return this.ordinal()+1;
    }
}
