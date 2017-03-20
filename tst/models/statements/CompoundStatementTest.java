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

/**
 * Created by xps on 03-Nov-16.
 */
public class CompoundStatementTest {
    @Test
    public void execute() throws Exception {
        CompoundStatement stmt1 = new CompoundStatement(new PrintStatement(new ConstExpression(2)), new PrintStatement(new ConstExpression(10)));
        PrgState prg1 = new PrgState(1, new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                new LockTable(new Hashtable<>()),
                stmt1);
        while(!prg1.getExeStack().isEmpty()) {
            IStatement crtStmt = prg1.getExeStack().pop();
            crtStmt.execute(prg1);
        }
        assertEquals(prg1.getOut().get(0), new Integer(2));
        assertEquals(prg1.getOut().get(1), new Integer(10));
    }

}