package views;

import controllers.Controller;
import models.ADTs.MyDictionary;
import models.ADTs.MyIDictionary;
import models.exceptions.ADTException;
import views.Commands.Command;

import java.util.Hashtable;
import java.util.Scanner;

public class Menu {

    MyIDictionary<String, Command> commands;

    public Menu(){
        this.commands = new MyDictionary<>(new Hashtable<>());
    }

    public void addCommand(Command c){
        try {
            commands.put(c.getKey(), c);
        }
        catch(ADTException e){
            System.out.println(e.getMessage());
        }
    }

    private void printMainMenu(){
//        System.out.println("\t1. Press 1 to run Program 1");
//        System.out.println("\t2. Press 2 to run Program 2");
//        System.out.println("\t3. Press 3 to run Program 3");
//        System.out.println("\t4. Press 4 to change flag state");
//        System.out.println("\t5. Press 5 to change log file path");
//        System.out.println("\t0. Press 0 te exit");
        System.out.println("Choose a program to run:");
        for(Command c: commands.values()){
            System.out.println(String.format("%4s: %s", c.getKey(), c.getDesc()));
        }
    }

    public void show(){
        Scanner s = new Scanner(System.in);
        while(true){
            printMainMenu();
            String commKey = s.nextLine();
            try {
                Command comm = commands.get(commKey);
                comm.execute();
            } catch (ADTException e) {
                System.out.println(e.getMessage());
            }
//            switch(opt){
//                case 1:
//                    try {
//
//                        ctrl[0].executeAllSteps();
//                        break;
//                    }
//                    catch(Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                case 2:
//                    try {
//
//                        ctrl[1].executeAllSteps();
//                        break;
//                    }
//                    catch(Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                case 3:
//                    try {
//                        IStatement prg3 = new CompoundStatement(new AssignStatement("v", new ConstExpression(2)), new PrintStatement(new VarExpression("v")));
//                        PrgState prgState3 = null;
//                        try {
//                            prgState3 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), prg3);
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                        }
//                        ctrl[2].clearRepo();
//                        ctrl[2].addToRepo(prgState3);
//                        ctrl[2].executeAllSteps();
//                        break;
//                    }
//                    catch(Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                case 4:
//                    for(Controller ctr:ctrl){
//                        ctr.setFlag(!ctr.getFlag());
//                    }
//                    System.out.println("Flag: " + Boolean.toString(ctrl[0].getFlag()));
//                    break;
//                case 5:
//                    System.out.print("Enter new file name: ");
//                    String fName = s.next();
//                case 0:
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid command");
//            }
        }
    }
}
