package views.Commands;

import controllers.Controller;

import java.io.IOException;

public class SerializeCommand extends Command{
    Controller ctrl;

    public SerializeCommand(String key, String desc, Controller ctrl){
        super(key, desc);
        this.ctrl = ctrl;
    }

    @Override
    public void execute() {
        try {
            ctrl.serializePrgState();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
