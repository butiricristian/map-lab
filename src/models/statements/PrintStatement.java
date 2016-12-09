package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIList;
import models.PrgState;
import models.expressions.Expression;

import java.io.Serializable;

public class PrintStatement implements IStatement, Serializable {
    Expression exp;

    public PrintStatement(Expression expression){
        exp = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception{
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIList<Integer> out = state.getOut();
        Integer eval = null;
        try {
            eval = exp.eval(symTable, state.getHeap());
        } catch (Exception e) {
            throw e;
        }
        out.add(eval);
        return null;
    }

    @Override
    public String toString(){
        return "print(" + exp.toString() + ")";
    }
}
