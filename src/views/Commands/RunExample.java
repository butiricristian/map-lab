package views.Commands;

import controllers.Controller;

/**
 * Created by xps on 17-Nov-16.
 */
public class RunExample extends Command {
    Controller ctrl;

    public RunExample(String key, String desc, Controller ctrl){
        super(key, desc);
        this.ctrl = ctrl;
    }

    @Override
    public void execute() {
        try {
            System.out.println(ctrl.executeAllSteps());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
