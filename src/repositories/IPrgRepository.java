package repositories;

import models.PrgState;
import models.exceptions.FileException;

public interface IPrgRepository {
    PrgState getCrtProgram();
    void addProgram(PrgState prg);
    void removeAll();
    boolean isEmpty();
    void logPrgStateExec(PrgState state) throws FileException;
    void setLogFilePath(String newPath);
}

