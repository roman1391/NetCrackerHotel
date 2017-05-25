package by.netcracker.hotel.enums;

/**
 * All possible options for status of certain review.
 * 
 * @author Roman Rodevich
 *
 */
public enum ReviewStatus {
    PENDING("pending"), APPROVED("approved"), BLOCKED("blocked");

    private String reviewStatus;

    ReviewStatus(String reviewInfo) {
        this.reviewStatus = reviewInfo;
    }

    public String getReviewInfo() {
        return reviewStatus;
    }

    public void setReviewInfo(String reviewInfo) {
        this.reviewStatus = reviewInfo;
    }

}
