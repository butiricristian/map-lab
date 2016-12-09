package models.expressions;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.exceptions.InvalidComparatorException;

import java.io.Serializable;

public class BooleanExpression extends Expression implements Serializable {
    Expression e1, e2;
    String comp;

    public BooleanExpression(String comp, Expression expr1, Expression expr2){
        this.comp = comp;
        this.e1 = expr1;
        this.e2 = expr2;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable, MyIHeap heap) throws Exception {
        switch (comp){
            case "<":
                return e1.eval(symTable, heap) < e2.eval(symTable, heap) ? 1 : 0;
            case "<=":
                return e1.eval(symTable, heap) <= e2.eval(symTable, heap) ? 1 : 0;
            case "==":
                return e1.eval(symTable, heap) == e2.eval(symTable, heap) ? 1 : 0;
            case "!=":
                return e1.eval(symTable, heap) != e2.eval(symTable, heap) ? 1 : 0;
            case ">":
                return e1.eval(symTable, heap) > e2.eval(symTable, heap) ? 1 : 0;
            case ">=":
                return e1.eval(symTable, heap) >= e2.eval(symTable, heap) ? 1 : 0;
            default:
                throw new InvalidComparatorException("Invalid comparison");
        }
    }

    @Override
    public String toString(){
        return e1.toString() + comp.toString() + e2.toString();
    }
}
