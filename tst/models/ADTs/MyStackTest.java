package models.ADTs;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class MyStackTest{
    MyStack<Integer> st;

    @Before
    public void setUp() throws Exception {
        st = new MyStack<>(new Stack<>());
        st.push(1);
    }

    @Test
    public void push() throws Exception {
        st.push(2);
        assertEquals(st.isEmpty(), false);
        assertEquals(st.pop(), new Integer(2));
    }

    @Test
    public void pop() throws Exception {
        st.push(2);
        assertEquals(st.isEmpty(), false);
        assertEquals(st.pop(), new Integer(2));
    }

    @Test
    public void isEmpty() throws Exception {
        st.pop();
        assertEquals(st.isEmpty(), true);
    }

}