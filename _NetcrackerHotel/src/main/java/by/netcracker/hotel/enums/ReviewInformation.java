package by.netcracker.hotel.enums;

/**
 * ReviewInformation defines possible actions user can do about review.
 * 
 * @author Roman Rodevich
 *
 */
public enum ReviewInformation {
    EXIST("exist"), NOT_EXIST("notExist"), FORBIDDEN("forbidden"), MODERATE("moderate");

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
