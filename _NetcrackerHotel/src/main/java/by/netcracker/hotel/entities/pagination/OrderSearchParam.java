package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationParam;

public class OrderSearchParam extends BoPaginationParam {

    private String username;
    private String hotelname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

}
