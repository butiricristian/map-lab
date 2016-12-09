package models.expressions;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.exceptions.HeapException;

import java.io.Serializable;

public class ReadHeap extends Expression implements Serializable {

    String varName;

    public ReadHeap(String varName){
        this.varName = varName;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable, MyIHeap heap) throws Exception {
        Integer addr = symTable.get(varName);
        if(!heap.contains(addr)) {
            throw new HeapException("The required address does not exist!");
        }
        return heap.get(symTable.get(varName));
    }

    @Override
    public String toString(){
        return "readHeap(" + varName + ")";
    }
}
