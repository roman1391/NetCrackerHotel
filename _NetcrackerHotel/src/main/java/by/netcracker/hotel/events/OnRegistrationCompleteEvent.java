package by.netcracker.hotel.events;

import org.springframework.context.ApplicationEvent;

import by.netcracker.hotel.entities.User;

/**
 * Created by slava on 13.04.17.
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String appUrl;
    private User user;

    public OnRegistrationCompleteEvent(User user, String appUrl) {
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