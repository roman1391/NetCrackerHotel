package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationResultRow;

public class ReviewRow extends BoPaginationResultRow<Integer> {

    private int reviewId;
    private String username;
    private String hotelname;
    private String status;
    private String time;

    @Override
    public Integer getPk() {
        return reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
