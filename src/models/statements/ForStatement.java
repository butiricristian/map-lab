package models.statements;

import models.PrgState;
import models.expressions.BooleanExpression;
import models.expressions.Expression;
import models.expressions.VarExpression;

public class ForStatement implements IStatement {

    String var;
    Expression exp1, exp2, exp3;
    IStatement body;

    public ForStatement(String var, Expression exp1, Expression exp2, Expression exp3, IStatement body){
        this.var = var;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
        this.body = body;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        IStatement forStmt = new CompoundStatement(
                new AssignStatement("v", exp1),
                new WhileStatement(new BooleanExpression("<", new VarExpression("v"), exp2),
                        new CompoundStatement(body, new AssignStatement("v", exp3)))
        );
        state.getExeStack().push(forStmt);
        return null;
    }

    @Override
    public String toString(){
        return "for(" + "var=" + exp1 + ";" + exp2 + ";" + var + "=" + exp3 + ")" + body;
    }
}
