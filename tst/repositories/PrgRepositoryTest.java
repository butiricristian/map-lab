package repositories;

import models.ADTs.MyDictionary;
import models.ADTs.MyFileTable;
import models.ADTs.MyList;
import models.ADTs.MyStack;
import models.PrgState;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import models.statements.AssignStatement;
import models.statements.CompoundStatement;
import models.statements.IStatement;
import models.statements.PrintStatement;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by xps on 03-Nov-16.
 */
public class PrgRepositoryTest {
    @Test
    public void addProgram() throws Exception {
        IStatement prg1 = new CompoundStatement(new AssignStatement("a", new ConstExpression(2)), new PrintStatement(new VarExpression("a")));
        PrgState prg = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), new MyFileTable(new HashMap<>()), prg1);
        PrgRepository repo = new PrgRepository(new MyList<>(new ArrayList<>()), "fileTest.txt");
        repo.addProgram(prg);
        assertEquals( repo.getAll().isEmpty(), false);
    }

    @Test
    public void getCrtProgram() throws Exception {
        IStatement prg1 = new CompoundStatement(new AssignStatement("a", new ConstExpression(2)), new PrintStatement(new VarExpression("a")));
        PrgState prg = new PrgState(new MyStack<>(new Stack<>()), new MyDictionary<>(new Hashtable<>()), new MyList<>(new ArrayList<>()), new MyFileTable(new HashMap<>()), prg1);
        PrgRepository repo = new PrgRepository(new MyList<>(new ArrayList<>()), "fileTest.txt");
        repo.addProgram(prg);
        assertNotEquals( repo.getCrtProgram(), null);
    }

}