package models.ADTs;

import models.exceptions.ADTException;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public interface MyIDictionary<K, T> {
    boolean isDefined(K key);
    void put(K key, T value) throws ADTException;
    void remove(K key) throws ADTException;
    void update(K key, T value) throws ADTException;
    T get(K key) throws ADTException;
    Set<K> keySet();
    boolean contains(K key);
    Collection<T> values();
    Hashtable<K, T> getContent();
    boolean isEmpty();
}