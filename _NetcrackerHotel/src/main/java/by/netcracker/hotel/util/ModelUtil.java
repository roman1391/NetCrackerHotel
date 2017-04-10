package by.netcracker.hotel.util;

import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import static by.netcracker.hotel.util.SecurityUtil.getRole;

/**
 * Created by Alexander on 11.04.2017.
 */
public class ModelUtil {

    public static ModelAndView createModel(String name, Authentication authentication){
        ModelAndView model = new ModelAndView();
        model.addObject("role", getRole(authentication));
        model.setViewName(name);
        return model;
    }
}
