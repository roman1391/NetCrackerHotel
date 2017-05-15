package by.netcracker.hotel.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.services.UserService;

public class CheckAuthorityInterceptor extends HandlerInterceptorAdapter {

    private User user;
    private final UserService userService;
    private WebApplicationContext context;

    @Autowired
    public CheckAuthorityInterceptor(UserService userService, WebApplicationContext context) {
        this.userService = userService;
        this.context = context;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }
        // boolean isBlocked;
        Object userInfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userInfo instanceof String) {
            System.out.println("userInfo: " + userInfo);
            user = (User) context.getBean("user");
            user.setUsername("GUEST");
            user.setAuthority(ROLE.GUEST);
        } else if (userInfo instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) userInfo;
            user = (User) userService.getUserByUsername(userDetails.getUsername());

            String userAuthority = Arrays.asList(userDetails.getAuthorities().toArray()).get(0).toString();
            System.out.println("userInfo:");
            System.out.println("Username - " + userDetails.getUsername());
            System.out.println("Authority - " + userAuthority);
            // modelAndView.addObject("role", ROLE.valueOf(userAuthority));
            // if (userAuthority.equals("BLOCKED")) {
            // isBlocked = true;
            // modelAndView.addObject("blocked_user", isBlocked);
            // }
        }
        request.getSession().setAttribute("currentUser", user);
    }
}