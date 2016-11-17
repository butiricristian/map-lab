package models;

import models.ADTs.MyDictionary;
import models.ADTs.MyIList;
import models.ADTs.MyList;
import models.ADTs.MyStack;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import models.statements.AssignStatement;
import models.statements.CompoundStatement;
import models.statements.IStatement;
import models.statements.PrintStatement;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by xps on 03-Nov-16.
 */
public class PrgStateTest {
    PrgState prg;

    @Before
    public void setUp() throws Exception {
        IStatement prg1 = new CompoundStatement(new AssignStatement("a", new ConstExpression(2)), new PrintStatement(new VarExpression("a")));
        prg = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), prg1);
    }

    @Test
    public void getExeStack() throws Exception {
        assertEquals(prg.getExeStack().isEmpty(), false);
    }

    @Test
    public void getSymTable() throws Exception {
        assertEquals(prg.getSymTable().isEmpty(), true);
    }

    @Test
    public void getOut() throws Exception {
        assertEquals(prg.getOut().isEmpty(), true);
    }

    @Test
    public void setExeStack() throws Exception {

    }

    @Test
    public void setSymTable() throws Exception {

    }

    @Test
    public void setOut() throws Exception {

    }

}