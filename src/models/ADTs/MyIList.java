package models.ADTs;

import models.PrgState;

import java.util.ArrayList;

public interface MyIList<T> {
    void add(T elem);
    T get(int pos);
    void remove(int pos);
    boolean isEmpty();
    void removeAll();
    ArrayList<T> getContent();
    void setContent(ArrayList<T> newContent);
}
