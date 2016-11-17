package models.exceptions;

public class ADTException extends Exception {
    String message;

    public ADTException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
