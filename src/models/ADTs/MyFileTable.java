package models.ADTs;

import models.exceptions.FileTableException;

import java.io.BufferedReader;
import java.io.Serializable;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Set;

public class MyFileTable implements MyIFileTable, Serializable{

    HashMap<Integer, MyITuple<String, BufferedReader>> fileTable;
    Integer prevIndex;

    public MyFileTable(HashMap<Integer, MyITuple<String, BufferedReader>> ft){
        fileTable =ft;
        prevIndex = 1;
    }

    @Override
    public Integer add(MyITuple pair) throws FileTableException {
        fileTable.put(prevIndex, pair);
        prevIndex++;
        return (prevIndex-1);
    }

    @Override
    public void remove(Integer key) throws FileTableException {
        if(fileTable.containsKey(key)) {
            fileTable.remove(key);
        }
        else{
            throw new FileTableException("File descriptor does not exist!");
        }
    }

    @Override
    public MyITuple get(Integer key) throws FileTableException {
        if(fileTable.containsKey(key)) {
            return fileTable.get(key);
        }
        else{
            throw new FileTableException("File descriptor does not exist!");
        }
    }

    @Override
    public Set<Integer> keySet(){
        return fileTable.keySet();
    }

    @Override
    public String toString(){
        return fileTable.toString();
    }
}
