package views.Commands;

import controllers.Controller;

import java.io.IOException;

/**
 * Created by xps on 02-Dec-16.
 */
public class DeserializeCommand extends Command {
    Controller ctrl;

    public DeserializeCommand(String key, String desc, Controller ctrl){
        super(key, desc);
        this.ctrl = ctrl;
    }

    @Override
    public void execute() {
        try {
            ctrl.deserializePrgState();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
