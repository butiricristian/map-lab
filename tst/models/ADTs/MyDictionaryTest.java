package models.ADTs;

import models.ADTs.MyDictionary;
import org.junit.Before;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.*;

public class MyDictionaryTest {

    MyDictionary<Integer, Integer> dict;
    @Before
    public void setUp() throws Exception {
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        dict = new MyDictionary<>(hash);
        dict.put(2, 2);
    }

    @Test
    public void isDefined() throws Exception {
        assertEquals(dict.isDefined(2), true);
        assertEquals(dict.isDefined(10), false);
    }

    @Test
    public void get() throws Exception {
        assertEquals(dict.get(2), new Integer(2));
        assertNotEquals(dict.get(2), new Integer(3));
    }

    @Test
    public void put() throws Exception {
        dict.put(3, 4);
        assertEquals(dict.isDefined(3), true);
        assertEquals(dict.get(3), new Integer(4));
    }

    @Test
    public void update() throws Exception {
        dict.update(2, 4);
        assertEquals(dict.get(2), new Integer(4));
        assertNotEquals(dict.get(2), new Integer(2));
    }

}