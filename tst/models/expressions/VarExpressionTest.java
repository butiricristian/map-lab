package models.expressions;

import models.ADTs.MyDictionary;
import models.exceptions.VarNotDefinedException;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.*;

public class VarExpressionTest {
    @Test
    public void eval() throws Exception {
        VarExpression expr = new VarExpression("v");
        MyDictionary<String, Integer> symTabel = new MyDictionary<>(new Hashtable<>());
        try {
            expr.eval(symTabel);
        }
        catch(VarNotDefinedException e){
            assertTrue(true);
        }
        symTabel.put("v", 10);
        assertEquals(expr.eval(symTabel), new Integer(10));

    }

}