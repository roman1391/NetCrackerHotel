package by.netcracker.hotel.controllers;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.services.UserService;
import by.netcracker.hotel.util.CloudinaryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

import static by.netcracker.hotel.util.CloudinaryUtil.saveFileToCloud;

@Controller
public class UserController {

    @Autowired
    public UserController(ServletContext context) {
        CloudinaryUtil.UPLOADED_FOLDER = context.getRealPath("/resources/img/");
    }

    @Autowired
    private UserService userService;

    class T {
        private UserDTO dto;
        private MultipartFile file;

        public UserDTO getDto() {
            return dto;
        }

        public void setDto(UserDTO dto) {
            this.dto = dto;
        }

        public MultipartFile getFile() {
            return file;
        }

        public void setFile(MultipartFile file) {
            this.file = file;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String save(@ModelAttribute("activeUser") UserDTO dto, @RequestParam("file") MultipartFile file) {
        dto.setAvatar(saveFileToCloud(file));
        userService.update(dto);
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
