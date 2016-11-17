package models.ADTs;
import java.util.ArrayList;

public class MyList<T> implements MyIList<T> {
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
}
