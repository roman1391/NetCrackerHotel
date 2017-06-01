package by.netcracker.hotel.social;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.services.UserService;
import jdk.nashorn.internal.runtime.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by slava on 20.04.17.
 */
public class SimpleSignInAdapter implements SignInAdapter {
    private final RequestCache requestCache;
    private UserDetailsService userService;

    @Resource(name="socialRememberMe")
    private RememberMeServices rememberMeServices;

    @Autowired
    public SimpleSignInAdapter(RequestCache requestCache,UserDetailsService userService) {
        this.requestCache = requestCache;
        this.userService = userService;
    }

    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        UserDetails user;
        try {
            user = userService.loadUserByUsername(localUserId);
        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            return "/?error=Failed to login by "+connection.getKey().getProviderId();
        }
        String provider = connection.getKey().getProviderId().toUpperCase();
        if(user.isEnabled()) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null,
                    user.getAuthorities());
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(token);
            rememberMeServices.loginSuccess((HttpServletRequest) request.getNativeRequest(),
                    (HttpServletResponse) request.getNativeResponse(), context.getAuthentication());
        } else{
            return "/?error=Account is disabled";
        }
        return extractOriginalUrl(request);
    }

    private String extractOriginalUrl(NativeWebRequest request) {
        HttpServletRequest nativeReq = request.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse nativeRes = request.getNativeResponse(HttpServletResponse.class);
        SavedRequest saved = requestCache.getRequest(nativeReq, nativeRes);
        if (saved == null) {
            return null;
        }
        requestCache.removeRequest(nativeReq, nativeRes);
        removeAutheticationAttributes(nativeReq.getSession(false));
        return saved.getRedirectUrl();
    }

    private void removeAutheticationAttributes(HttpSession session) {
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
