package models.ADTs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by xps on 03-Nov-16.
 */
public class MyListTest {
    MyList<Integer> lst;

    @Before
    public void setUp(){
        lst = new MyList<>(new ArrayList<>());
        lst.add(3);
    }

    @Test
    public void add() throws Exception {
        lst.add(5);
        assertEquals(lst.get(1), new Integer(5));
    }

    @Test
    public void get() throws Exception {
        assertEquals(lst.get(0), new Integer(3));
    }

    @Test
    public void remove() throws Exception {
        lst.remove(0);
        assertEquals(lst.isEmpty(), true);
    }

}