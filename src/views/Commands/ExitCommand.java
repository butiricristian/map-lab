package views.Commands;

import controllers.Controller;

/**
 * Created by xps on 17-Nov-16.
 */
public class ExitCommand extends Command {
    public ExitCommand(String key, String desc){
        super(key, desc);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
