package models.exceptions;

public class HeapException extends Exception {
    String message;

    public HeapException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
