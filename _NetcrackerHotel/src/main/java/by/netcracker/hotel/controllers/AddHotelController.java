package by.netcracker.hotel.controllers;

import by.netcracker.hotel.cloud.CloudinaryConnector;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Varvara on 4/11/2017.
 */

@Controller
@RequestMapping(value = "/hotel")
public class AddHotelController {

    private final HotelService hotelService;
    private final PhotoService photoService;

    private static String UPLOADED_FOLDER;
    private final ServletContext context;

    @Autowired
    public AddHotelController(ServletContext context, HotelService hotelService, PhotoService photoService) {
        this.context = context;
        UPLOADED_FOLDER = this.context.getRealPath("/resources/img/");
        this.hotelService = hotelService;
        this.photoService = photoService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String about(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "add_hotel";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addHotel(@ModelAttribute("hotel") Hotel hotel, @RequestParam("file") MultipartFile file,
                           Model model) {
        hotelService.addHotel(hotel);
        if (!file.isEmpty()) {
            Photo photo = new Photo(hotel.getId());
            photoService.addPhoto(photo);
            hotelService.setMainPhotoForHotel(hotel.getId(), photo.getIdPhoto());
            savePhotoInCloudinary(file, photo.getPhotoName());
            String photoUrl = CloudinaryConnector.getCloudinary().url().format("jpg").generate(photo.getPhotoName());
            hotel.setPhotoURL(photoUrl);
        }
        model.addAttribute("id", hotel.getId());
        return "success_adding_hotel";
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.POST)
    public String addPhotosToHotel(@PathVariable("id") int hotelID, @RequestParam("files") List<MultipartFile> files, Model model) {
        for (MultipartFile file : files) {
            Photo photo = new Photo(hotelID);
            photoService.addPhoto(photo);
            savePhotoInCloudinary(file, photo.getPhotoName());
        }
        model.addAttribute("hotel", hotelService.getByID(hotelID));
        List<String> photosUrl = new ArrayList<>();
        for (Photo photo : photoService.getPhotosForHotel(hotelID)) {
            String photoUrl = CloudinaryConnector.getCloudinary().url().format("jpg").generate(photo.getPhotoName());
            photosUrl.add(photoUrl);
        }
        model.addAttribute("photos", photosUrl);
        return "success_adding_hotel";
    }

    private void savePhotoInCloudinary(MultipartFile file, String photoName) {
        File convFile = new File(UPLOADED_FOLDER + "img");
        try {
            file.transferTo(convFile);
            Map uploadResult = CloudinaryConnector.getCloudinary().uploader().upload(convFile,
                    CloudinaryConnector.picureTransform(photoName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
