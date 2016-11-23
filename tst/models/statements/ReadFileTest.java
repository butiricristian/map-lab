package models.statements;

import models.ADTs.*;
import models.PrgState;
import models.expressions.VarExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class ReadFileTest {
    @Test
    public void execute() throws Exception {
        IStatement read = new CompoundStatement(new OpenRFile("var_f", "test.in"), new CompoundStatement(new ReadFile(new VarExpression("var_f"), "var_c"), new  CloseRFile(new VarExpression("var_f"))));
        PrgState prg = new PrgState(new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                read);
        while(!prg.getExeStack().isEmpty()) {
            IStatement res = prg.getExeStack().pop();
            res.execute(prg);
        }
        assertEquals(prg.getSymTable().get("var_c"), new Integer(15));
    }

}