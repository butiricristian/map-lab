package models.statements;

import models.ADTs.*;
import models.PrgState;
import models.expressions.ConstExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class WriteHeapTest {
    @Test
    public void execute() throws Exception {
        IStatement heapNew = new CompoundStatement(new HeapNew("v", new ConstExpression(10)), new WriteHeap("v", new ConstExpression(15)));
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
        assertEquals(prg.getHeap().get(1), new Integer(15));
        assertEquals(prg.getSymTable().get("v"), new Integer(1));
    }

}