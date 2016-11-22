package models.exceptions;

/**
 * Created by xps on 22-Nov-16.
 */
public class FileTableException extends Exception {
    String message;

    public FileTableException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
