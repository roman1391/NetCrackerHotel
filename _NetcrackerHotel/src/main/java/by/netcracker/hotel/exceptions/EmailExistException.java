package by.netcracker.hotel.exceptions;

/**
 * Created by slava on 07.04.17.
 */
public class EmailExistException extends Exception {
    public EmailExistException(){
        super();
    }
    public EmailExistException(String message){
        super(message);
    }
}
