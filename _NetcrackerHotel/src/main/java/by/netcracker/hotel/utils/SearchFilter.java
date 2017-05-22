package by.netcracker.hotel.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Varvara on 3/30/2017.
 */
public class SearchFilter {

    private String place;

    private String startDate;

    private String endDate;

    private Integer [] stars;

    private Integer minCost;

    private Integer maxCost;

    private Integer capacity;

    public SearchFilter() {
    }

    public SearchFilter(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() { return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer[] getStars() {
        return stars;
    }

    public void setStars(Integer[] stars) {
        this.stars = stars;
    }

    public Integer getMinCost() {
        return minCost;
    }

    public void setMinCost(Integer minCost) {
        this.minCost = minCost;
    }

    public Integer getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(Integer maxCost) {
        this.maxCost = maxCost;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
