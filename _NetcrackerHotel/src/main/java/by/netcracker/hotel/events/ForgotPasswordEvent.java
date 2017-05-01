package by.netcracker.hotel.events;

import by.netcracker.hotel.entities.User;
import org.springframework.context.ApplicationEvent;

/**
 * Created by slava on 02.05.17.
 */
public class ForgotPasswordEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String appUrl;
    private User user;

    public ForgotPasswordEvent(User user, String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
