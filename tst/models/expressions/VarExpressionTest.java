package models.expressions;

import models.ADTs.MyDictionary;
import models.ADTs.MyHeap;
import models.exceptions.VarNotDefinedException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class VarExpressionTest {
    @Test
    public void eval() throws Exception {
        VarExpression expr = new VarExpression("v");
        MyDictionary<String, Integer> symTable = new MyDictionary<>(new Hashtable<>());
        MyHeap heap = new MyHeap(new HashMap<>());
        try {
            expr.eval(symTable, heap);
        }
        catch(VarNotDefinedException e){
            assertTrue(true);
        }
        symTable.put("v", 10);
        assertEquals(expr.eval(symTable, heap), new Integer(10));
    }

}