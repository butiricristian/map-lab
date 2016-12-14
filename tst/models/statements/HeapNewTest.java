package models.statements;

import models.ADTs.*;
import models.PrgState;
import models.exceptions.FileTableException;
import models.expressions.ConstExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class HeapNewTest {
    @Test
    public void execute() throws Exception {
        IStatement heapNew = new HeapNew("v", new ConstExpression(10));
        PrgState prg = new PrgState(1, new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                heapNew);
        while(!prg.getExeStack().isEmpty()) {
            IStatement res = prg.getExeStack().pop();
            res.execute(prg);
        }
        assertEquals(prg.getHeap().get(1), new Integer(10));
        assertEquals(prg.getSymTable().contains("v"), true);
    }

}