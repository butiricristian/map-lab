package models.statements;

import models.ADTs.MyIStack;
import models.PrgState;
import java.io.Serializable;

public class CompoundStatement implements IStatement, Serializable {

    IStatement stmt1, stmt2;

    public CompoundStatement(IStatement s1, IStatement s2){
        stmt1 = s1;
        stmt2 = s2;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception{
        MyIStack<IStatement> exeStack = state.getExeStack();
        exeStack.push(stmt2);
        exeStack.push(stmt1);
        return null;
    }

    @Override
    public String toString(){
        return stmt1.toString() + ";" + stmt2.toString();
    }
}
