package models.ADTs;

import models.exceptions.ADTException;

import java.util.Stack;

public interface MyIStack<T> {
    boolean isEmpty();
    void push(T el) throws  ADTException;
    T pop() throws ADTException;
}
