package repositories;

import models.PrgState;
import models.exceptions.FileException;

import java.io.IOException;

public interface IPrgRepository {
    PrgState getCrtProgram();
    void addProgram(PrgState prg);
    void removeAll();
    boolean isEmpty();
    void logPrgStateExec(PrgState state) throws FileException;
    void setLogFilePath(String newPath);
    void serialize() throws IOException;
    void deserialize() throws IOException, ClassNotFoundException;
}

