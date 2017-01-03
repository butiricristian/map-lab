package models.ADTs;

import models.exceptions.HeapException;

import java.util.HashMap;
import java.util.Map;

public interface MyIHeap {
    Integer add(Integer value);
    Integer get(Integer address) throws HeapException;
    void remove(Integer address) throws HeapException;
    void update(Integer address, Integer value) throws HeapException;
    void setContent(HashMap<Integer, Integer> newHeap);
    HashMap<Integer, Integer> getContent();
    boolean contains(Integer address);
}
