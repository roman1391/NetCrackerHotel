package by.netcracker.hotel.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;

/**
 * Created by Varvara on 4/16/2017.
 */
public class CloudinaryConnector {
    private static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "netcrackerhotel",
            "api_key", "912781383186464",
            "api_secret", "wXSaMZLwqevzZ3EqtVD9VmZvzO0"));

    public static Cloudinary getCloudinary() {
        return cloudinary;
    }
}
