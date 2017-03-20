package models.statements;

import models.ADTs.*;
import models.PrgState;
import models.exceptions.ADTException;
import models.exceptions.FileException;
import models.exceptions.FileTableException;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class OpenRFileTest {
    @Test
    public void execute() throws Exception {
        IStatement open = new OpenRFile("var_f", "test.in");
        PrgState prg = new PrgState(1, new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                new LockTable(new Hashtable<>()),
                open);
        open.execute(prg);
        try {
            prg.getFileTable().get(1);
            assertTrue(true);
        }
        catch (FileTableException e){
            assertFalse(true);
        }

        try {
            IStatement open2 = new CompoundStatement(new OpenRFile("var_f", "test.in"), new OpenRFile("var_j", "test.in"));
            PrgState prg2 = new PrgState(1, new MyStack<>(new Stack<>()),
                    new MyDictionary<>(new Hashtable<>()),
                    new MyList<>(new ArrayList<>()),
                    new MyFileTable(new HashMap<>()),
                    new MyHeap(new HashMap<>()),
                    new LockTable(new Hashtable<>()),
                    open2);
            while(!prg2.getExeStack().isEmpty()) {
                IStatement res = prg2.getExeStack().pop();
                res.execute(prg2);
            }
            assertFalse(true);
        }
        catch(FileException e){
            assertTrue(true);
        }
    }

}