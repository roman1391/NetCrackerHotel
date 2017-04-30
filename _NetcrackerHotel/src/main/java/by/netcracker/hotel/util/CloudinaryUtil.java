package by.netcracker.hotel.util;

import by.netcracker.hotel.cloud.CloudinaryConnector;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Alexander on 18.04.2017.
 */
public class CloudinaryUtil {
    private static final int MAX_SIZE_PHOTO = 400;
    public static String UPLOADED_FOLDER;


    public static String saveFileToCloud(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                File convFile = new File(UPLOADED_FOLDER + "img");
                file.transferTo(convFile);
                Long id = new Date().getTime();

                CloudinaryConnector.getCloudinary().uploader().upload(convFile,
                        CloudinaryConnector.pictureTransform(id.toString(), MAX_SIZE_PHOTO));
                return CloudinaryConnector.getCloudinary().url().format("jpg").generate(id.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}