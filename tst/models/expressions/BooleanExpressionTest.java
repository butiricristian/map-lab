package models.expressions;

import models.ADTs.MyDictionary;
import models.ADTs.MyHeap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class BooleanExpressionTest {
    @Test
    public void eval() throws Exception {
        BooleanExpression expr = new BooleanExpression("<", new ConstExpression(0), new ConstExpression(3));
        assertEquals(expr.eval(new MyDictionary<>(new Hashtable<>()), new MyHeap(new HashMap<>())), new Integer(1));
    }

}