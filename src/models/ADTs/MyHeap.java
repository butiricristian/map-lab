package models.ADTs;

import models.exceptions.HeapException;

import java.util.HashMap;

public class MyHeap implements MyIHeap {

    HashMap<Integer, Integer> heap;
    Integer prevAddr;

    public MyHeap(HashMap<Integer, Integer> heap){
        this.heap = heap;
        prevAddr = 1;
    }

    @Override
    public void add(Integer value) {
        heap.put(prevAddr, value);
        prevAddr++;
    }

    @Override
    public Integer get(Integer address) throws HeapException {
        if(heap.containsKey(address)){
            return heap.get(address);
        }
        else{
            throw new HeapException("Address not found");
        }
    }

    @Override
    public void remove(Integer address) throws HeapException{
        if(heap.containsKey(address)){
            heap.remove(address);
        }
        else{
            throw new HeapException("Address not found");
        }
    }

    @Override
    public String toString(){
        return heap.toString();
    }
}
