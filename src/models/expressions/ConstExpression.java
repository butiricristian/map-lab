package models.expressions;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;

import java.io.Serializable;

public class ConstExpression extends Expression implements Serializable{
    int number;

    public ConstExpression(int number){
        this.number = number;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable, MyIHeap heap) throws Exception {
        return number;
    }

    public String toString(){
        return Integer.toString(number);
    }
}
