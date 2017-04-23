package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationResultRow;

public class HotelRow extends BoPaginationResultRow<Integer> {

    private int hotelId;
    private String name;
    private String typeOfService;
    private String country;
    private String city;

    @Override
    public Integer getPk() {
        return hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

}
