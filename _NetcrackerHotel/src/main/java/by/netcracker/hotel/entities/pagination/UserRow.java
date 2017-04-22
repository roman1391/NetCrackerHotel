package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationResultRow;

public class UserRow extends BoPaginationResultRow<Integer> {
    private int userId;
    private String authority;
    private String enabled;
    private String username;
    private String email;

    @Override
    public Integer getPk() {
        return userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

}
