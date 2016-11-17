package views;

import controllers.Controller;
import models.ADTs.MyDictionary;
import models.ADTs.MyList;
import models.ADTs.MyStack;
import models.PrgState;
import models.expressions.ArithmExpression;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import models.statements.AssignStatement;
import models.statements.CompoundStatement;
import models.statements.IStatement;
import models.statements.PrintStatement;
import repositories.IPrgRepository;
import repositories.PrgRepository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class Menu {

    Controller[] ctrl;

    public Menu(Controller[] ctrl){
        this.ctrl = ctrl;
    }

    private void printMainMenu(){
        System.out.println("Choose a program to run:");
        System.out.println("\t1. Press 1 to run Program 1");
        System.out.println("\t2. Press 2 to run Program 2");
        System.out.println("\t3. Press 3 to run Program 3");
        System.out.println("\t4. Press 4 to change flag state");
        System.out.println("\t5. Press 5 to change log file path");
        System.out.println("\t0. Press 0 te exit");
    }

    public void show(){
        Scanner s = new Scanner(System.in);
        while(true){
            printMainMenu();
            int opt;
            if(s.hasNextInt()) {
                opt = s.nextInt();
            }
            else{
                opt = -1;
            }
            switch(opt){
                case 1:
                    try {
                        IStatement prg1 = new CompoundStatement(new AssignStatement("v", new ConstExpression(2)), new PrintStatement(new VarExpression("v")));
                        PrgState prgState1 = null;
                        try {
                            prgState1 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), prg1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        ctrl[0].clearRepo();
                        ctrl[0].addToRepo(prgState1);
                        ctrl[0].executeAllSteps();
                        break;
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        IStatement prg2 = new CompoundStatement(
                                new CompoundStatement(
                                        new AssignStatement("a",
                                                new ArithmExpression("+",
                                                        new ConstExpression(2),
                                                        new ArithmExpression("*",
                                                                new ConstExpression(3),
                                                                new ConstExpression(5)))),
                                        new AssignStatement("b",
                                                new ArithmExpression("+",
                                                        new VarExpression("a"),
                                                        new ConstExpression(1)))),
                                new PrintStatement(new VarExpression("b")));
                        PrgState prgState2 = null;
                        try {
                            prgState2 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), prg2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        ctrl[1].clearRepo();
                        ctrl[1].addToRepo(prgState2);
                        ctrl[1].executeAllSteps();
                        break;
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                case 3:
                    try {
                        IStatement prg3 = new CompoundStatement(new AssignStatement("v", new ConstExpression(2)), new PrintStatement(new VarExpression("v")));
                        PrgState prgState3 = null;
                        try {
                            prgState3 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), prg3);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        ctrl[2].clearRepo();
                        ctrl[2].addToRepo(prgState3);
                        ctrl[2].executeAllSteps();
                        break;
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                case 4:
                    for(Controller ctr:ctrl){
                        ctr.setFlag(!ctr.getFlag());
                    }
                    System.out.println("Flag: " + Boolean.toString(ctrl[0].getFlag()));
                    break;
                case 5:
                    System.out.print("Enter new file name: ");
                    String fName = s.next();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
