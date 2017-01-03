package models.statements;

import models.ADTs.*;
import models.PrgState;
import models.exceptions.FileTableException;
import models.expressions.ArithmExpression;
import models.expressions.BooleanExpression;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class WhileStatementTest {
    @Test
    public void execute() throws Exception {
        IStatement whileStmt = new CompoundStatement(new AssignStatement("v", new ConstExpression(0)), new WhileStatement(new BooleanExpression("<", new VarExpression("v"), new ConstExpression(5)), new AssignStatement("v", new ArithmExpression("+", new VarExpression("v"), new ConstExpression(1)))));
        PrgState prg = new PrgState(1, new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                whileStmt);
        while(!prg.getExeStack().isEmpty()) {
            IStatement res = prg.getExeStack().pop();
            res.execute(prg);
        }
        assertEquals(prg.getSymTable().get("v"), new Integer(5));
    }

}