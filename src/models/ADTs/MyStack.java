package models.ADTs;
import models.exceptions.ADTException;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T>, Serializable {
    Stack<T> stack;
    public MyStack(Stack<T> e){
        stack = e;
    }

    @Override
    public void push(T el) throws ADTException{
        try {
            stack.push(el);
        }
        catch (StackOverflowError e){
            throw new ADTException("Stack is Full");
        }
    }

    @Override
    public T pop() throws ADTException{
        try {
            return stack.pop();
        }catch (EmptyStackException e){
            throw new ADTException("Empty stack!");
        }
    }

    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        return stack.toString();
    }
}
