package by.netcracker.hotel.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckAuthorityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		boolean isBlocked = false;
		Object info = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (info instanceof String) {
			System.out.println("userInfo: " + info);
		} else if (info instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) info;
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
	}
}
