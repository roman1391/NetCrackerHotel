package by.netcracker.hotel.enums;

/**
 * ReviewInformation defines possibility to leave review by user.
 * 
 * @author Roman Rodevich
 *
 */
public enum ReviewInformation {
    EXIST("exist"), NOT_EXIST("notExist"), FORBIDDEN("forbidden");

    private String reviewInfo;

    ReviewInformation(String reviewInfo) {
        this.reviewInfo = reviewInfo;
    }

    public String getReviewInfo() {
        return reviewInfo;
    }

    public void setReviewInfo(String reviewInfo) {
        this.reviewInfo = reviewInfo;
    }

}
