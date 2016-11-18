package models.statements;

import models.ADTs.MyDictionary;
import models.ADTs.MyList;
import models.ADTs.MyStack;
import models.PrgState;
import models.expressions.ConstExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class IfStatementTest {
    @Test
    public void execute() throws Exception {
        IfStatement stmt1 = new IfStatement(new ConstExpression(3), new AssignStatement("a", new ConstExpression(1)), new AssignStatement("a", new ConstExpression(0)));
        PrgState prg1 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), new MyDictionary<>(new Hashtable<>()), stmt1);
        while(!prg1.getExeStack().isEmpty()) {
            IStatement crtStmt = prg1.getExeStack().pop();
            crtStmt.execute(prg1);
        }
        assertEquals(prg1.getSymTable().get("a"), new Integer(1));

        IfStatement stmt2 = new IfStatement(new ConstExpression(0), new AssignStatement("a", new ConstExpression(1)), new AssignStatement("a", new ConstExpression(0)));
        PrgState prg2 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), new MyDictionary<>(new Hashtable<>()), stmt2);
        while(!prg2.getExeStack().isEmpty()) {
            IStatement crtStmt = prg2.getExeStack().pop();
            crtStmt.execute(prg2);
        }
        assertEquals(prg2.getSymTable().get("a"), new Integer(0));
    }

}