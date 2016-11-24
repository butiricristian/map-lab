package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.PrgState;
import models.expressions.Expression;

public class WriteHeap implements IStatement {

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
        return state;
    }

    @Override
    public String toString(){
        return "writeHeap(" + varName + ", " + expr.toString() + ")";
    }
}
