package views.Commands;

import controllers.Controller;

import java.util.Scanner;

public class ChangeLogFilePath extends Command {
    Controller ctrl;

    public ChangeLogFilePath(String key, String desc, Controller ctrl){
        super(key, desc);
        this.ctrl = ctrl;
    }

    @Override
    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.print("New log file path: ");
        String fileName = s.nextLine();
        ctrl.changeLogFile(fileName);
        System.out.println("File path has been changed to " + fileName);
    }
}
