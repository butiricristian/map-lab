package models.expressions;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.exceptions.DivBy0Exception;
import models.exceptions.InvalidOperationException;

import java.io.Serializable;

public class ArithmExpression extends Expression implements Serializable {

    String operation;
    Expression term1;
    Expression term2;

    public ArithmExpression(String operation, Expression expression1, Expression expression2){
        this.operation = operation;
        term1 = expression1;
        term2 = expression2;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable, MyIHeap heap) throws Exception {
        switch (operation) {
            case "+":
                return term1.eval(symTable, heap) + term2.eval(symTable, heap);
            case "-":
                return term1.eval(symTable, heap) - term2.eval(symTable, heap);
            case "*":
                return term1.eval(symTable, heap) * term2.eval(symTable, heap);
            case "/":
                if(term2.eval(symTable, heap) == 0)
                    throw new DivBy0Exception("Division by 0 error");
                return term1.eval(symTable, heap) / term2.eval(symTable, heap);
            default:
                throw new InvalidOperationException("Invalid Operation!");
        }
    }

    @Override
    public String toString(){
        return term1.toString() + " " + operation + " " + term2.toString();
    }
}
