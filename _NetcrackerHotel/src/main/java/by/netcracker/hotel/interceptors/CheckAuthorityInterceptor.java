package by.netcracker.hotel.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.services.UserService;

public class CheckAuthorityInterceptor extends HandlerInterceptorAdapter {

	private User user;
	private final UserService userService;

	@Autowired
	public CheckAuthorityInterceptor(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null)
			return;
		boolean isBlocked;
		Object info = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (info instanceof String) {
			System.out.println("userInfo: " + info);
			user = new User();
			user.setUsername("GUEST");
			user.setAuthority(ROLE.GUEST);
		} else if (info instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) info;
			user = (User) userService.getUserByUsername(userDetails.getUsername());

			String auth = Arrays.asList(userDetails.getAuthorities().toArray()).get(0).toString();
			System.out.println("userInfo:");
			System.out.println("Username - " + userDetails.getUsername());
			System.out.println("Authority - " + auth);
			if (auth.equals("BLOCKED")) {
				isBlocked = true;
				modelAndView.addObject("blocked_user", isBlocked);
				modelAndView.setViewName("home");
			}
		}
		modelAndView.addObject("currentUser", user);
	}
}