package models.exceptions;

public class FileException extends Exception {
    String message;

    public FileException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
