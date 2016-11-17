package models.ADTs;
import models.exceptions.ADTException;

import java.util.Hashtable;
import java.util.Set;

public class MyDictionary<K, T> implements MyIDictionary<K, T> {
    Hashtable<K, T> dict;

    public MyDictionary(Hashtable<K, T> dictParam) {
        dict = dictParam;
    }

    @Override
    public boolean isDefined(K key) {
        return dict.containsKey(key);
    }

    @Override
    public T get(K key) throws ADTException {
        try{
            return dict.get(key);
        }
        catch (NullPointerException e){
            throw new ADTException("Key not found");
        }
    }

    @Override
    public void put(K key, T value) throws ADTException {
        try {
            dict.put(key, value);
        }
        catch (NullPointerException e){
            throw new ADTException("Key or value are null");
        }
    }

    @Override
    public void remove(K key) throws ADTException{
        try {
            dict.remove(key);
        }
        catch(Exception e){
            throw new ADTException("Key not found");
        }
    }

    @Override
    public void update(K key, T value) throws ADTException {
        if(dict.containsKey(key)) {
            dict.replace(key, value);
        }
        else{
            throw new ADTException("Key not found");
        }
    }

    @Override
    public Set<K> keySet(){
        return dict.keySet();
    }

    @Override
    public String toString() {
        return dict.toString();
    }

    @Override
    public boolean isEmpty(){ return dict.isEmpty(); }
}
