package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;

/**
 * Created by slava on 15.04.17.
 */
public interface VerificationTokenDAO extends AbstractDAO<VerificationToken,Integer> {

    VerificationToken getByToken(String token);

    VerificationToken getByUserID(int userID);
}
