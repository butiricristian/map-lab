package models.exceptions;

/**
 * Created by xps on 03-Nov-16.
 */
public class ExeStackEmptyException extends Exception {
    String message;

    public ExeStackEmptyException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
