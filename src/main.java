import controllers.Controller;
import models.ADTs.*;
import models.PrgState;
import models.expressions.*;
import models.statements.*;
import repositories.IPrgRepository;
import repositories.PrgRepository;
import views.Commands.*;
import views.Menu;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class main {
    public static void main(String[] args){
        //PROGRAM 1
        IPrgRepository prgRepo1 = new PrgRepository(new MyList<>(new ArrayList<>()), "file1.txt");
        Controller ctrl1 = new Controller(prgRepo1);
        IStatement prg1 = new CompoundStatement(new AssignStatement("v", new ConstExpression(2)), new PrintStatement(new VarExpression("v")));
        PrgState prgState1 = null;
        try {
            prgState1 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl1.clearRepo();
        ctrl1.addToRepo(prgState1);



        //PROGRAM 2
        IPrgRepository prgRepo2 = new PrgRepository(new MyList<>(new ArrayList<>()), "file2.txt");
        Controller ctrl2 = new Controller(prgRepo2);
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
            prgState2 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl2.clearRepo();
        ctrl2.addToRepo(prgState2);




        //PROGRAM 3
        IPrgRepository prgRepo3 = new PrgRepository(new MyList<>(new ArrayList<>()), "file3.txt");
        Controller ctrl3 = new Controller(prgRepo3);
        IStatement prg3 = new CompoundStatement(
                new OpenRFile("var_f", "test.in"),
                new CompoundStatement(
                        new ReadFile(new VarExpression("var_f"), "var_c"),
                        new CompoundStatement(
                            new PrintStatement(new VarExpression("var_c")),
                            new CompoundStatement(
                                    new IfStatement(new VarExpression("var_c"),
                                            new CompoundStatement(
                                                    new ReadFile(new VarExpression("var_f"), "var_c"),
                                                    new PrintStatement(new VarExpression("var_c"))
                                            ),
                                            new PrintStatement(new ConstExpression(0))
                                    ),
                                    new CloseRFile(new VarExpression("var_f"))
                            )
                        )
                )
        );
        PrgState prgState3 = null;
        try {
            prgState3 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    prg3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl3.clearRepo();
        ctrl3.addToRepo(prgState3);




        //PROGRAM 4
        IPrgRepository prgRepo4 = new PrgRepository(new MyList<>(new ArrayList<>()), "file4.txt");
        Controller ctrl4 = new Controller(prgRepo4);
        IStatement prg4 = new CompoundStatement(
                new OpenRFile("var_f", "test.in"),
                new CompoundStatement(
                        new ReadFile(new ArithmExpression("+", new VarExpression("var_f"), new ConstExpression(2)), "var_c"),
                        new CompoundStatement(
                                new PrintStatement(new VarExpression("var_c")),
                                new CompoundStatement(
                                        new IfStatement(new VarExpression("var_c"),
                                                new CompoundStatement(
                                                        new ReadFile(new VarExpression("var_f"), "var_c"),
                                                        new PrintStatement(new VarExpression("var_c"))
                                                ),
                                                new PrintStatement(new ConstExpression(0))
                                        ),
                                        new CloseRFile(new VarExpression("var_f"))
                                )
                        )
                )
        );
        PrgState prgState4 = null;
        try {
            prgState4 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl4.clearRepo();
        ctrl4.addToRepo(prgState4);




        //PROGRAM 5
        IPrgRepository prgRepo5 = new PrgRepository(new MyList<>(new ArrayList<>()), "file5.txt");
        Controller ctrl5 = new Controller(prgRepo5);
        IStatement prg5 = new CompoundStatement(
                new CompoundStatement(
                new AssignStatement("v", new ConstExpression(10)),
                new CompoundStatement(
                        new HeapNew("v", new ConstExpression(20)),
                        new CompoundStatement(
                                new HeapNew("a", new ConstExpression(22)),
                                new CompoundStatement(
                                        new WriteHeap("a", new ConstExpression(30)),
                                        new CompoundStatement(
                                             new PrintStatement(new VarExpression("a")),
                                             new CompoundStatement(
                                                     new PrintStatement(new ReadHeap("a")),
                                                     new AssignStatement("a", new ConstExpression(0))
                                             )
                                        )
                                )
                        )
                )
            ),
                new CompoundStatement(
                        new AssignStatement("v", new ConstExpression(0)),
                        new CompoundStatement(
                                new WhileStatement(new BooleanExpression("<", new VarExpression("v"), new ConstExpression(5)),
                                        new AssignStatement("v",
                                                new ArithmExpression("+", new VarExpression("v"), new ConstExpression(1))
                                        )
                                ),
                                new PrintStatement(new VarExpression("v"))
                        )
                )
        );
        PrgState prgState5 = null;
        try {
            prgState5 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl5.clearRepo();
        ctrl5.addToRepo(prgState5);


        //PROGRAM 6
        IPrgRepository prgRepo6 = new PrgRepository(new MyList<>(new ArrayList<>()), "file6.txt");
        Controller ctrl6 = new Controller(prgRepo6);
        IStatement prg6 = new CompoundStatement(
                new AssignStatement("v", new ConstExpression(0)),
                new CompoundStatement(
                    new WhileStatement(new BooleanExpression("<", new VarExpression("v"), new ConstExpression(5)),
                            new AssignStatement("v",
                                new ArithmExpression("+", new VarExpression("v"), new ConstExpression(1))
                            )
                    ),
                    new PrintStatement(new VarExpression("v"))
                )
        );
        PrgState prgState6 = null;
        try {
            prgState6 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()), prg6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ctrl6.clearRepo();
        ctrl6.addToRepo(prgState6);




        Menu m = new Menu();
        m.addCommand(new ExitCommand("0", "Press 0 to exit"));
        m.addCommand(new RunExample("1", "Press 1 to run program 1", ctrl1));
        m.addCommand(new RunExample("2", "Press 2 to run program 2", ctrl2));
        m.addCommand(new RunExample("3", "Press 3 to run program 3", ctrl3));
        m.addCommand(new RunExample("4", "Press 4 to run program 4", ctrl4));
        m.addCommand(new RunExample("5", "Press 5 to run program 5", ctrl5));
        m.addCommand(new RunExample("6", "Press 6 to run program 6", ctrl6));
        m.addCommand(new ChangeLogFilePath("C1", "Type C1 to change the log path for program 1", ctrl1));
        m.addCommand(new ChangeLogFilePath("C2", "Type C2 to change the log path for program 2", ctrl2));
        m.addCommand(new ChangeLogFilePath("C3", "Type C3 to change the log path for program 3", ctrl3));
        m.addCommand(new ChangeLogFilePath("C4", "Type C4 to change the log path for program 4", ctrl4));
        m.addCommand(new ChangeLogFilePath("C5", "Type C5 to change the log path for program 5", ctrl5));
        m.addCommand(new ChangeLogFilePath("C6", "Type C6 to change the log path for program 6", ctrl6));

        m.show();
    }
}
