package models.ADTs;

import models.exceptions.HeapException;

public interface MyIHeap {
    void add(Integer value);
    Integer get(Integer address) throws HeapException;
    void remove(Integer address) throws HeapException;
}
