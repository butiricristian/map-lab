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

public class PrintStatementTest {
    @Test
    public void execute() throws Exception {
        PrintStatement stmt1 = new PrintStatement(new ConstExpression(20));
        PrgState prg1 = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), stmt1);
        stmt1.execute(prg1);
        assertEquals(prg1.getOut().get(0), new Integer(20));
    }

}