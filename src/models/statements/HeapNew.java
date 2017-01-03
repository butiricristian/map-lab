package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.PrgState;
import models.expressions.Expression;

import java.io.Serializable;

public class HeapNew implements IStatement, Serializable {

    String var_name;
    Expression expr;

    public HeapNew(String var, Expression ex){
        var_name = var;
        expr = ex;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTbl = state.getSymTable();
        Integer addr = state.getHeap().add(expr.eval(symTbl, state.getHeap()));
        if(!symTbl.contains(var_name)) {
            symTbl.put(var_name, addr);
        }
        else{
            symTbl.update(var_name, addr);
        }
        return null;
    }

    @Override
    public String toString(){
        return "new(" + var_name + ", " + expr.toString() + ")";
    }
}
