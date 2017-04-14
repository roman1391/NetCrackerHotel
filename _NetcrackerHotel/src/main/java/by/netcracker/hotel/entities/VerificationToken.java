package by.netcracker.hotel.entities;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Created by slava on 15.04.17.
 */
public class VerificationToken {
    @Id
    private int id;

    private String token;

    private int userID;

    public VerificationToken() {
    }

    private Date date;

    public VerificationToken(String token, int userID, Date date) {
        this.token = token;
        this.userID = userID;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerificationToken that = (VerificationToken) o;
        return getId() == that.getId() &&
                getUserID() == that.getUserID() &&
                Objects.equals(getToken(), that.getToken()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getToken(), getUserID(), getDate());
    }
}
