package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIStack;
import models.PrgState;
import models.exceptions.DivBy0Exception;
import models.exceptions.VarNotDefinedException;
import models.expressions.Expression;

import java.io.Serializable;

public class IfStatement implements IStatement, Serializable{
    Expression exp;
    IStatement thenStmt;
    IStatement elseStmt;

    public IfStatement(Expression condExp, IStatement stmtIf, IStatement stmtElse){
        exp = condExp;
        thenStmt = stmtIf;
        elseStmt = stmtElse;
    }


    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIStack<IStatement> stack = state.getExeStack();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        Integer eval = null;
        try {
            eval = exp.eval(symTable, state.getHeap());
        } catch (VarNotDefinedException e) {
            throw e;
        }
        catch(DivBy0Exception e){
            throw e;
        }
        if(eval != 0){
            stack.push(thenStmt);
        }
        else{
            stack.push(elseStmt);
        }
        return null;
    }

    @Override
    public String toString(){
        return "If(" + exp.toString() + ") Then: " + thenStmt.toString() +
                "Else" + elseStmt.toString();
    }
}
