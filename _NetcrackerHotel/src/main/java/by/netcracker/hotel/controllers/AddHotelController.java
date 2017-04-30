package by.netcracker.hotel.controllers;

import by.netcracker.hotel.cloud.CloudinaryConnector;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Varvara on 4/11/2017.
 */

@Controller
@RequestMapping(value = "/hotel")
public class AddHotelController {

    private static final int MAX_SIZE_MAIN_PHOTO = 400;
    private static final String DEFAULT_MAIN_PHOTO = "BTTELV";
    private final HotelService hotelService;
    private final RoomService roomService;

    private static String UPLOADED_FOLDER;
    private final ServletContext context;

    @Autowired
    public AddHotelController(ServletContext context, HotelService hotelService, RoomService roomService) {
        this.context = context;
        this.roomService = roomService;
        UPLOADED_FOLDER = this.context.getRealPath("/resources/img/");
        this.hotelService = hotelService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "add_hotel";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addHotel(@ModelAttribute("hotel") Hotel hotel, @RequestParam("file") MultipartFile file,
                           Model model) {
        if (!file.isEmpty()) {
            String photo = CloudinaryConnector.generateNameForPhoto();
            hotel.setMainPhoto(photo);
            savePhotoInCloudinary(file, photo, MAX_SIZE_MAIN_PHOTO);
        } else {
            hotel.setMainPhoto(DEFAULT_MAIN_PHOTO);
        }
        hotelService.addHotel(hotel);
        model.addAttribute("id", hotel.getId());
        return "add_hotel_photo_and_description";
    }

    @RequestMapping(value = "{id}/photo", method = RequestMethod.POST)
    public String addPhotosToHotel(@PathVariable("id") int hotelID, @RequestParam("files") List<MultipartFile> files, Model model) {
        Hotel hotel = hotelService.getByID(hotelID);
        if (!files.get(0).isEmpty()) {
            for (MultipartFile file : files) {
                String photo = CloudinaryConnector.generateNameForPhoto();
                hotel.addPhoto(photo);
                savePhotoInCloudinary(file, photo, 0);
                hotelService.addPhoto(photo, hotelID);
            }
        } else {
            model.addAttribute("message", "Please, choose photo to add");
        }
        model.addAttribute("hotel", hotel);
        model.addAttribute("id", hotelID);
        return "add_hotel_photo_and_description";
    }

    @RequestMapping(value = "/{id}/room", method = RequestMethod.GET)
    public String rooms(@PathVariable("id") int hotelID, Model model) {
        model.addAttribute("hotel", hotelService.getByID(hotelID));
        model.addAttribute("id", hotelID);
        model.addAttribute("room", new Room());
        return "add_rooms_to_hotel";
    }

    @RequestMapping(value = "/{id}/room", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("room") Room room, @PathVariable("id") int hotelID, Model model) {
        model.addAttribute("hotel", hotelService.getByID(hotelID));
        model.addAttribute("id", hotelID);
        room.setHotelID(hotelID);
        roomService.add(room);
        model.addAttribute("rooms", roomService.getByHotelID(hotelID));
        return "add_rooms_to_hotel";
    }

    private void savePhotoInCloudinary(MultipartFile file, String photoName, int size) {
        File convFile = new File(UPLOADED_FOLDER + "img");
        try {
            file.transferTo(convFile);
            Map uploadResult = CloudinaryConnector.getCloudinary().uploader().upload(convFile,
                    CloudinaryConnector.pictureTransform(photoName, size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
