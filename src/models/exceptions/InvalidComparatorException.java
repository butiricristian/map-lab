package models.exceptions;

/**
 * Created by xps on 02-Dec-16.
 */
public class InvalidComparatorException extends Exception{
    String message;

    public InvalidComparatorException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
