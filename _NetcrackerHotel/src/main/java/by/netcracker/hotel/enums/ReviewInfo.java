package by.netcracker.hotel.enums;

public enum ReviewInfo {
    EXIST("exist"), NOT_EXIST("notExist"), FORBIDDEN("forbidden"), MODERATE("moderate");

    private String reviewInfo;

    ReviewInfo(String reviewInfo) {
        this.reviewInfo = reviewInfo;
    }

    public String getReviewInfo() {
        return reviewInfo;
    }

    public void setReviewInfo(String reviewInfo) {
        this.reviewInfo = reviewInfo;
    }

}
