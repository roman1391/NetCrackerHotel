package by.netcracker.hotel.entities;

public class Review {

    private int id;
    private int userId;
    private int hotelId;
    private String text;
    private String status;
    private String date;
    private int rating;

    public Review() {
    }

    public Review(int id, int userId, int hotelId, String text, String status, String date, int rating) {
        super();
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.text = text;
        this.status = status;
        this.date = date;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback [id=" + id + ", userId=" + userId + ", hotelId=" + hotelId + ", text=" + text + ", status="
            + status + ", date=" + date + ", rating=" + rating + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + hotelId;
        result = prime * result + id;
        result = prime * result + rating;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + userId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Review other = (Review) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (hotelId != other.hotelId)
            return false;
        if (id != other.id)
            return false;
        if (rating != other.rating)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }

}
