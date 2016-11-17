package models.ADTs;

/**
 * Created by xps on 14-Nov-16.
 */
public class MyTuple<T1, T2> implements MyITuple<T1, T2> {
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
}
