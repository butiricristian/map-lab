package models.statements;

import models.ADTs.MyIStack;
import models.PrgState;
import models.expressions.Expression;

import java.io.Serializable;

public class WhileStatement implements IStatement, Serializable {
    Expression expr;
    IStatement body;

    public WhileStatement(Expression ex1, IStatement body){
        this.expr = ex1;
        this.body = body;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIStack<IStatement> exeStack = state.getExeStack();
        if(expr.eval(state.getSymTable(), state.getHeap()) != 0){
            exeStack.push(this);
            exeStack.push(body);
        }
        return null;
    }

    @Override
    public String toString(){
        return "while(" + expr + "){ " + body.toString() + " }";
    }
}
