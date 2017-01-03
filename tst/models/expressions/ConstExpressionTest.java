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
public class ConstExpressionTest {
    @Test
    public void eval() throws Exception {
        ConstExpression expr = new ConstExpression(5);
        assertEquals(expr.eval(new MyDictionary<>(new Hashtable<>()), new MyHeap(new HashMap<>())), new Integer(5));
    }

}