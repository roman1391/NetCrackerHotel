package by.netcracker.hotel.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;

/**
 * Created by Varvara on 4/16/2017.
 */
public class CloudinaryConnector {
    private static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "netcrackerhotel",
            "api_key", "912781383186464",
            "api_secret", "wXSaMZLwqevzZ3EqtVD9VmZvzO0",
            "secure", true));

    public static Cloudinary getCloudinary() {
        return cloudinary;
    }

    public static Map pictureTransform(String name, int size) {
        if (size > 0) {
            return ObjectUtils.asMap("public_id", name,
                    "transformation", new Transformation().crop("limit").width(size).height(size));
        }
        return ObjectUtils.asMap("public_id", name);
    }


    public static String generateNameForPhoto() {
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * COUNT_SYMBOLS + MIN_SYMBOLS);
        for (int i = 0; i < count; i++) {
            randString.append((char) ((int) (Math.random() * SYMBOLS + 'A')));
        }
        return randString.toString();
    }

    private final static int SYMBOLS = 26, COUNT_SYMBOLS = 27, MIN_SYMBOLS = 3;
}
