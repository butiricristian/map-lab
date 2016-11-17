package models.statements;

import models.PrgState;

public interface IStatement {
    PrgState execute(PrgState state) throws Exception;
}
