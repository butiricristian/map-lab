package controllers;

import models.ADTs.*;
import models.PrgState;
import models.expressions.ConstExpression;
import models.expressions.VarExpression;
import models.statements.AssignStatement;
import models.statements.CompoundStatement;
import models.statements.IStatement;
import models.statements.PrintStatement;
import org.junit.Test;
import repositories.IPrgRepository;
import repositories.PrgRepository;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by xps on 03-Nov-16.
 */
public class ControllerTest {
    @Test
    public void executeOneStep() throws Exception {
        IPrgRepository prgRepo1 = new PrgRepository(new MyList<>(new ArrayList<>()), "fileTest.txt");
        Controller ctrl1 = new Controller(prgRepo1);
        IStatement prg1 = new PrintStatement(new ConstExpression(2));
        PrgState prgState1 = new PrgState(1, new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                new LockTable(new Hashtable<>()),
                prg1);
        prgRepo1.addProgram(prgState1);
        ctrl1.oneStepForAllPrg((List)prgRepo1.getPrgList());
        assertEquals(prgState1.getOut().get(0), new Integer(2));
        assertEquals(prgState1.getExeStack().isEmpty(), true);
    }

    @Test
    public void executeAllSteps() throws Exception {
        IPrgRepository prgRepo1 = new PrgRepository(new MyList<>(new ArrayList<>()), "fileTest.txt");
        Controller ctrl1 = new Controller(prgRepo1);
        IStatement prg1 = new CompoundStatement(new AssignStatement("v", new ConstExpression(2)), new PrintStatement(new VarExpression("v")));
        PrgState prgState1 = new PrgState(1, new MyStack<>(new Stack<>()),
                new MyDictionary<>(new Hashtable<>()),
                new MyList<>(new ArrayList<>()),
                new MyFileTable(new HashMap<>()),
                new MyHeap(new HashMap<>()),
                new LockTable(new Hashtable<>()),
                prg1);
        prgRepo1.addProgram(prgState1);
        ctrl1.executeAllSteps();
        assertEquals(prgState1.getExeStack().isEmpty(), true);
        assertEquals(prgState1.getOut().get(0), new Integer(2));
        assertEquals(prgState1.getSymTable().isDefined("v"), true);
    }

}