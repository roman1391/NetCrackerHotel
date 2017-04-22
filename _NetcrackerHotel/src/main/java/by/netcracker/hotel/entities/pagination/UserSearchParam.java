package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationParam;

public class UserSearchParam extends BoPaginationParam {

    private String authority;
    private String enabled;
    private String username;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
