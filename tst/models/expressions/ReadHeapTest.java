package models.expressions;

import models.ADTs.MyDictionary;
import models.ADTs.MyHeap;
import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.statements.IStatement;
import models.statements.WriteHeap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Created by xps on 08-Dec-16.
 */
public class ReadHeapTest {
    @Test
    public void eval() throws Exception {
        MyIHeap heap = new MyHeap(new HashMap<>());
        MyIDictionary symTable = new MyDictionary(new Hashtable());
        symTable.put("v", 1);
        heap.add(10);
        ReadHeap rh = new ReadHeap("v");
        assertEquals(rh.eval(symTable, heap), new Integer(10));
    }

}