package models.ADTs;

import java.util.Hashtable;

public interface ILockTable {
    Integer put(Integer value);
    Integer get(Integer key);
    Hashtable<Integer, Integer> getContent();
    boolean containsKey(Integer key);
    void update(Integer key, Integer value);
}
