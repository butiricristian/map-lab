package models.statements;

import models.PrgState;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockVarStatement implements IStatement {
    String var;
    Lock lock;

    public LockVarStatement(String var){
        this.var = var;
        lock = new ReentrantLock();
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
//        lock.lock();
        synchronized (state.getLockTable()) {
            Integer foundIndex = state.getSymTable().get(var);
            if (!state.getLockTable().containsKey(foundIndex)) {
                throw new Exception("No key in lock table");
            } else if (state.getLockTable().get(foundIndex) == -1) {
                state.getLockTable().update(foundIndex, state.getId());
            } else {
                state.getExeStack().push(this);
            }
//        lock.unlock();
        }
        return null;
    }

    @Override
    public String toString(){
        return "lock(" + var + ")";
    }
}
