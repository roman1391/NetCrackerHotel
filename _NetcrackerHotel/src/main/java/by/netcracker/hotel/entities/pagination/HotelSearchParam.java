package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationParam;

public class HotelSearchParam extends BoPaginationParam {

    private String name;
    private String city;
    private String enabled;
    private String typeOfService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

}
