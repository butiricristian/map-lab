package models.statements;

import models.ADTs.MyIDictionary;
import models.PrgState;
import models.exceptions.DivBy0Exception;
import models.exceptions.VarNotDefinedException;
import models.expressions.Expression;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

public class AssignStatement implements IStatement, Serializable {

    String var;
    Expression exp;

    public AssignStatement(String id, Expression expression){
        var = id;
        exp = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        Integer eval = null;
        try {
            eval = exp.eval(symTable, state.getHeap());
        } catch (VarNotDefinedException e) {
            throw e;
        }
        catch (DivBy0Exception e){
            throw e;
        }
        if(symTable.isDefined(var)){
            symTable.update(var, eval);
        }
        else{
            symTable.put(var, eval);
        }
        return null;
    }

    @Override
    public String toString(){
        return var + "=" + exp.toString();
    }


}
