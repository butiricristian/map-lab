package models.ADTs;

import models.exceptions.HeapException;

public interface MyIHeap {
    Integer add(Integer value);
    Integer get(Integer address) throws HeapException;
    void remove(Integer address) throws HeapException;
    void update(Integer address, Integer value) throws HeapException;
    boolean contains(Integer address);
}
