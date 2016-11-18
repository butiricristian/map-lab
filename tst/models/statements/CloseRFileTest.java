package models.statements;

import models.ADTs.MyDictionary;
import models.ADTs.MyList;
import models.ADTs.MyStack;
import models.PrgState;
import models.exceptions.ADTException;
import models.exceptions.FileException;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

public class CloseRFileTest {
    @Test
    public void execute() throws Exception {
        IStatement close = new CompoundStatement(new OpenRFile("var_f", "test.in"), new CloseRFile(new VarExpression("var_f")));
        PrgState prg = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), new MyDictionary<>(new Hashtable<>()), close);
        while(!prg.getExeStack().isEmpty()) {
            IStatement res = prg.getExeStack().pop();
            res.execute(prg);
        }
        try{
            prg.getFileTable().get(1);
            assertFalse(true);
        }
        catch(ADTException e){
            assertTrue(true);
        }
    }

}