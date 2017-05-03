package by.netcracker.hotel.entities;

import java.util.Date;

/**
 * Created by Alexander on 25.04.2017.
 */
public class Order {
    private int id;
    private int roomId;
    private int userId;
    private Date arrivalDate;
    private Date leaveDate;
    private int payValue;
    private boolean isPaid;
    private String firstName;
    private String lastName;

    public Order() {
    }

    public Order(int id, int roomId, int userId, Date arrivalDate, Date leaveDate, int payValue, boolean isPaid,
        String firstName, String lastName) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        this.payValue = payValue;
        this.isPaid = isPaid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getPayValue() {
        return payValue;
    }

    public void setPayValue(int payValue) {
        this.payValue = payValue;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
