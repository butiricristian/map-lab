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

public class AssignStatementTest {
    @Test
    public void execute() throws Exception {
        AssignStatement stmt1 = new AssignStatement("a", new ConstExpression(3));
        PrgState prg = new PrgState(new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                stmt1);
        assertEquals(stmt1.execute(prg).getSymTable().get("a"), new Integer(3));
    }

}