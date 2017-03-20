package models.statements;

import models.ADTs.MyIDictionary;
import models.PrgState;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewLockStatement implements IStatement{
    String var;
//    Lock lock;

    public NewLockStatement(String var){
        this.var = var;
//        lock = new ReentrantLock();
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        synchronized (state.getLockTable()) {
//        lock.lock();
            Integer freeLoc = state.getLockTable().put(-1);
            if (symTable.contains(var)) {
                symTable.update(var, freeLoc);
            } else {
                symTable.put(var, freeLoc);
            }
//        lock.unlock();
        }
        return null;
    }

    @Override
    public String toString(){
        return "newLock(" + var + ")";
    }
}
