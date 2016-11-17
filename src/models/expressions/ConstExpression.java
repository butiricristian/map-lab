package models.expressions;

import models.ADTs.MyIDictionary;

public class ConstExpression extends Expression {
    int number;

    public ConstExpression(int number){
        this.number = number;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable) throws Exception {
        return number;
    }

    public String toString(){
        return Integer.toString(number);
    }
}
