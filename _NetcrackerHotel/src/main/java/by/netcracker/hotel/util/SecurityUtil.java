package by.netcracker.hotel.util;

import by.netcracker.hotel.enums.ROLE;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Set;

/**
 * Created by Alexander on 11.04.2017.
 */
public class SecurityUtil {

    public static ROLE getRole(Authentication authentication) {
        try {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            return ROLE.valueOf(roles.iterator().next());
        } catch (Exception e) {
            return ROLE.GUEST;
        }
    }

}
