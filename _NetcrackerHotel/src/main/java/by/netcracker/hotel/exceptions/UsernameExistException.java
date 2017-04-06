package by.netcracker.hotel.exceptions;

/**
 * Created by slava on 07.04.17.
 */
public class UsernameExistException extends Exception {
    public UsernameExistException(){
        super();
    }
    public UsernameExistException(String message){
        super(message);
    }
}
