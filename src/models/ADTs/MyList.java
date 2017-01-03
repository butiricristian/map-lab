package models.ADTs;
import models.PrgState;

import java.io.Serializable;
import java.util.ArrayList;

public class MyList<T> implements MyIList<T>, Serializable {
    ArrayList<T> list;

    public MyList(ArrayList<T> arr){
        list = arr;
    }

    @Override
    public void add(T elem) {
        list.add(elem);
    }

    @Override
    public T get(int pos) {
        return list.get(pos);
    }

    @Override
    public void remove(int pos) {
        list.remove(pos);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean isEmpty(){ return list.isEmpty(); }

    @Override
    public void removeAll(){
        list.clear();
    }

    @Override
    public ArrayList<T> getContent() {
        return list;
    }

    @Override
    public void setContent(ArrayList<T> newContent){
        list = newContent;
    }
}
