package models.statements;

import models.ADTs.MyDictionary;
import models.ADTs.MyIDictionary;
import models.ADTs.MyIStack;
import models.ADTs.MyStack;
import models.PrgState;

import java.util.Hashtable;
import java.util.Stack;

public class ForkStatement implements IStatement {
    IStatement stmt;
    static int id;

    public ForkStatement(IStatement stmt){
        this.stmt = stmt;
        id = 0;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIStack newExeStack = new MyStack(new Stack());
        MyIDictionary newSymTable = new MyDictionary<String, Integer>(new Hashtable<>());
        MyIDictionary<String, Integer> oldSymTable = state.getSymTable();
        for(String key:oldSymTable.keySet()){
            newSymTable.put(key, oldSymTable.get(key));
        }
        PrgState prgState2 = new PrgState(state.getId()*10 + id,
                newExeStack,
                newSymTable,
                state.getOut(),
                state.getFileTable(),
                state.getHeap(),
                state.getLockTable(),
                stmt);
        id++;
        return prgState2;
    }

    @Override
    public String toString(){
        return "fork(" + stmt.toString() + ")";
    }
}
