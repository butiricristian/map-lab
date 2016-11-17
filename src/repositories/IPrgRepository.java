package repositories;

import models.PrgState;

public interface IPrgRepository {
    PrgState getCrtProgram();
    void addProgram(PrgState prg);
    void removeAll();
    boolean isEmpty();
    void logPrgStateExec(PrgState state);
}

