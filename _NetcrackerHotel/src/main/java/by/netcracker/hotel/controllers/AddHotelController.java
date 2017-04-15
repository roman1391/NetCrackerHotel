package by.netcracker.hotel.controllers;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Varvara on 4/11/2017.
 */

@Controller
public class AddHotelController {
    final ServletContext context;
    private final HotelService hotelService;
    private final PhotoService photoService;

    private static String UPLOADED_FOLDER;

    @Autowired
    public AddHotelController(ServletContext context, HotelService hotelService, PhotoService photoService) {
        this.context = context;
        UPLOADED_FOLDER = context.getRealPath("/resources/img/");
        this.hotelService = hotelService;
        this.photoService = photoService;
    }

    @RequestMapping(value = "add-hotel", method = RequestMethod.POST)
    public String addHotel(@ModelAttribute("hotel") Hotel hotel, @RequestParam("file") MultipartFile file,
                           Model model) {
        int hotelID = hotelService.addHotel(hotel);
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                photoService.addPhoto(new Photo(hotelID, file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success_adding_hotel";
    }

}
