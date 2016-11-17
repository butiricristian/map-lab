package models.exceptions;
/**
 * Created by xps on 03-Nov-16.
 */
public class DivBy0Exception extends Exception {
    String message;

    public DivBy0Exception(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
