package models.exceptions;

/**
 * Created by xps on 03-Nov-16.
 */
public class InvalidOperationException extends Exception {
    String message;

    public InvalidOperationException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
