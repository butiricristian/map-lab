package models.statements;

import models.PrgState;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xps on 25-Jan-17.
 */
public class UnlockVarStatement implements IStatement{
    String var;

    public UnlockVarStatement(String var){
        this.var = var;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        synchronized (state.getLockTable()) {
            Integer foundIndex = state.getSymTable().get(var);
            if (state.getLockTable().get(foundIndex) == state.getId()) {
                state.getLockTable().update(foundIndex, -1);
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "unlock(" + var + ")";
    }
}
