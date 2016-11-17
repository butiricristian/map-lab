package models.expressions;

import models.ADTs.MyIDictionary;
import models.exceptions.VarNotDefinedException;

public class VarExpression extends Expression {
    String varName;

    public VarExpression(String var){
        varName = var;
    }

    @Override
    public Integer eval(MyIDictionary<String, Integer> symTable) throws Exception {
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
