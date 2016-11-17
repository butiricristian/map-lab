package models.exceptions;

public class VarNotDefinedException extends Exception {
    String message;
    public  VarNotDefinedException(String msg){
        message = msg;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
