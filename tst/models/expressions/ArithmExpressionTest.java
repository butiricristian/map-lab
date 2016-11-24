package models.expressions;

import models.ADTs.MyDictionary;
import models.ADTs.MyHeap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Created by xps on 03-Nov-16.
 */
public class ArithmExpressionTest {
    @Test
    public void eval() throws Exception {
        ArithmExpression expr1 = new ArithmExpression("+", new ConstExpression(2), new ConstExpression(2));
        assertEquals(expr1.eval(new MyDictionary<>(new Hashtable<>()), new MyHeap(new HashMap<>())), new Integer(4));
    }

}