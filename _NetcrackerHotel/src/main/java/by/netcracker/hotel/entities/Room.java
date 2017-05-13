package by.netcracker.hotel.entities;

import org.springframework.stereotype.Component;

@Component
public class Room {

    private int id;
    private int cost;
    private int capacity;
    private int hotelID;

    public Room(int id, int cost, int capacity, int hotelID) {
        this.id = id;
        this.cost = cost;
        this.capacity = capacity;
        this.hotelID = hotelID;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }
}
