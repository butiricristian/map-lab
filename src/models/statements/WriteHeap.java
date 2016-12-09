package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.PrgState;
import models.expressions.Expression;

import java.io.Serializable;

public class WriteHeap implements IStatement, Serializable {

    String varName;
    Expression expr;

    public WriteHeap(String var, Expression ex){
        varName = var;
        expr = ex;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIHeap heap = state.getHeap();
        Integer address = symTable.get(varName);
        heap.update(address, expr.eval(symTable, heap));
        return null;
    }

    @Override
    public String toString(){
        return "writeHeap(" + varName + ", " + expr.toString() + ")";
    }
}
