package by.netcracker.hotel.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Alexander on 18.04.2017.
 */
public class CloudinaryUtil {
    private static final int MAX_SIZE_PHOTO = 400;
    private static String uploadedFolder;

    public static void setUploadedFolder(String uploadedFolder){
        CloudinaryUtil.uploadedFolder = uploadedFolder;
    }

    public static String saveAvatarToCloud(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                File convFile = new File(uploadedFolder + "img");
                file.transferTo(convFile);
                String nameForPhoto = CloudinaryConnector.generateNameForPhoto();

                CloudinaryConnector.getCloudinary().uploader().upload(convFile,
                        CloudinaryConnector.pictureTransform(nameForPhoto, MAX_SIZE_PHOTO));
                return CloudinaryConnector.getCloudinary().url().format("jpg").generate(nameForPhoto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static void savePhotoInCloudinary(MultipartFile file, String photoName, int size) {
        File convFile = new File(uploadedFolder + "img");
        try {
            file.transferTo(convFile);
            Map uploadResult = CloudinaryConnector.getCloudinary().uploader().upload(convFile,
                    CloudinaryConnector.pictureTransform(photoName, size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}