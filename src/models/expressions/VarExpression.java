package models.expressions;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIHeap;
import models.exceptions.VarNotDefinedException;

import java.io.Serializable;

public class VarExpression extends Expression implements Serializable {
    String varName;

    public VarExpression(String var){
        varName = var;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable, MyIHeap heap) throws Exception {
        if(symTable.isDefined(varName)) {
            return symTable.get(varName);
        }
        else{
            throw new VarNotDefinedException("Undefined variable");
        }
    }

    @Override
    public String toString(){
        return varName;
    }
}
