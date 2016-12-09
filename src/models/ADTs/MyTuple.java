package models.ADTs;

import java.io.Serializable;

public class MyTuple<T1, T2> implements MyITuple<T1, T2>, Serializable {
    T1 first;
    T2 second;

    public MyTuple(T1 fst, T2 sec){
        first = fst;
        second = sec;
    }

    @Override
    public T1 getFirst(){
        return first;
    }

    @Override
    public T2 getSecond(){
        return second;
    }

    @Override
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
}
