package by.netcracker.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Varvara on 3/31/2017.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @RequestMapping(method = RequestMethod.GET)
    public String getSearchPage(){
        return "search";
    }


}
