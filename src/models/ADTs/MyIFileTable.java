package models.ADTs;

import models.exceptions.FileTableException;

import java.io.BufferedReader;
import java.util.Set;

public interface MyIFileTable {
    Integer add(MyITuple pair) throws FileTableException;
    void remove(Integer key) throws FileTableException;
    Set<Integer> keySet();
    MyITuple<String, BufferedReader> get(Integer key) throws FileTableException;
}
