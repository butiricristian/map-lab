package models.ADTs;

import java.util.ArrayList;

public interface MyIList<T> {
    void add(T elem);
    T get(int pos);
    void remove(int pos);
    boolean isEmpty();
    void removeAll();
}
