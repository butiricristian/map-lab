package models.ADTs;

import models.exceptions.HeapException;

import java.util.HashMap;
import java.util.Map;

public class MyHeap implements MyIHeap {

    HashMap<Integer, Integer> heap;
    Integer prevAddr;

    public MyHeap(HashMap<Integer, Integer> heap){
        this.heap = heap;
        prevAddr = 1;
    }

    @Override
    public Integer add(Integer value) {
        heap.put(prevAddr, value);
        prevAddr++;
        return (prevAddr-1);
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
    public void update(Integer address, Integer value) throws HeapException {
        if(heap.containsKey(address)){
            heap.replace(address, value);
        }
        else{
            throw new HeapException("Address not found");
        }
    }

    @Override
    public void setContent(HashMap<Integer, Integer> newHeap) {
        heap = newHeap;
    }

    @Override
    public HashMap<Integer, Integer> getContent() {
        return heap;
    }

    @Override
    public boolean contains(Integer address){
        return heap.containsKey(address);
    }

    @Override
    public String toString(){
        return heap.toString();
    }
}
