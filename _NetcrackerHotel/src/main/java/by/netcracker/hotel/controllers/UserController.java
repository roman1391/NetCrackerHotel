package by.netcracker.hotel.controllers;

import static by.netcracker.hotel.utils.CloudinaryUtil.saveAvatarToCloud;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;
import by.netcracker.hotel.utils.CloudinaryUtil;

@Controller
@SessionScope
@SessionAttributes("currentUser")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    public UserController(ServletContext context, ApplicationEventPublisher eventPublisher) {
        CloudinaryUtil.setUploadedFolder(context.getRealPath("/resources/img/"));
    }

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String save(@ModelAttribute("edited_user") User user, @RequestParam("file") MultipartFile file,
        Model model) {
        if (!file.getOriginalFilename().isEmpty()) {
            user.setAvatar(saveAvatarToCloud(file));
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User existUser = userService.getUserByUsername(userDetails.getUsername());
        try {
                userService.profileUpdate(user);
                model.addAttribute("message","You successfully update profile");
        } catch (UsernameExistException e) {
                log.info("UsernameExistException in userController while updating user");
                model.addAttribute("error", "Account with username - " + user.getUsername() + " are exist");
                return "profile";
        } catch (EmailExistException e) {
                log.info("EmailExistException in userController while updating user");
                model.addAttribute("error", "Account with email - " + user.getEmail() + " are exist");
                return "profile";
        } finally {
            model.addAttribute("edited_user",userService.getByID(user.getId()));
            UserDetails updateUser = userDetailsService.loadUserByUsername(user.getUsername());
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(updateUser,null,updateUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return "profile";
    }

    @RequestMapping(value = "/log-out", method = RequestMethod.POST)
    public ModelAndView logOut() {
        ModelAndView model = new ModelAndView();
        model.addObject("role", ROLE.GUEST);
        model.setViewName("about");
        return model;
    }

}
