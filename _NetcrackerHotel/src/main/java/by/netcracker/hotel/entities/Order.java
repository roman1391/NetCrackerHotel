package by.netcracker.hotel.entities;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Created by Alexander on 25.04.2017.
 */
@Component
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
    private String username;
    private String hotelname;

    public Order() {
    }

    public Order(int id, int roomId, int userId, Date arrivalDate, Date leaveDate, int payValue, String firstName,
        String lastName, String username, String hotelname) {
        super();
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        this.payValue = payValue;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.hotelname = hotelname;
    }

    public Order(int id, int roomId, int userId, Date arrivalDate, Date leaveDate, int payValue, String firstName,
        String lastName) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        this.payValue = payValue;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (arrivalDate == null) {
            if (other.arrivalDate != null)
                return false;
        }
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (hotelname == null) {
            if (other.hotelname != null)
                return false;
        } else if (!hotelname.equals(other.hotelname))
            return false;
        if (id != other.id)
            return false;
        if (isPaid != other.isPaid)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (leaveDate == null) {
            if (other.leaveDate != null)
                return false;
        }
        if (payValue != other.payValue)
            return false;
        if (roomId != other.roomId)
            return false;
        if (userId != other.userId)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

}
