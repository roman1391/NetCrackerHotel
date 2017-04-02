package by.netcracker.hotel.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/about")
public class AboutController {
    @RequestMapping(method = RequestMethod.GET)
    public String about(){
        return "about";
    }
}
