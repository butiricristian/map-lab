package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIList;
import models.PrgState;
import models.expressions.Expression;

public class PrintStatement implements IStatement {
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
            eval = exp.eval(symTable);
        } catch (Exception e) {
            throw e;
        }
        out.add(eval);
        return state;
    }

    @Override
    public String toString(){
        return "print(" + exp.toString() + ")";
    }
}
