package models.ADTs;

import java.util.Hashtable;

public class LockTable implements ILockTable {
    Hashtable<Integer, Integer> lockTable;
    Integer freeLoc;

    public LockTable(Hashtable<Integer, Integer> lockTable){
        this.lockTable = lockTable;
        freeLoc = 0;
    }

    @Override
    public Integer put(Integer value) {
        lockTable.put(freeLoc, value);
        freeLoc++;
        return freeLoc - 1;
    }

    @Override
    public Integer get(Integer key) {
        return lockTable.get(key);
    }

    @Override
    public Hashtable<Integer, Integer> getContent() {
        return lockTable;
    }

    @Override
    public boolean containsKey(Integer key) {
        return lockTable.containsKey(key);
    }

    @Override
    public void update(Integer key, Integer value) {
        lockTable.replace(key, value);
    }


}
