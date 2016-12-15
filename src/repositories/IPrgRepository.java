package repositories;

import models.ADTs.MyIList;
import models.PrgState;
import models.exceptions.FileException;

import java.io.IOException;
import java.util.ArrayList;

public interface IPrgRepository {
    PrgState getCrtProgram();
    void addProgram(PrgState prg);
    void removeAll();
    boolean isEmpty();
    void logPrgStateExec(PrgState state) throws FileException;
    void setLogFilePath(String newPath);
    void serialize() throws IOException;
    void deserialize() throws IOException, ClassNotFoundException;
    MyIList<PrgState> getPrgList();
    void setPrgList(ArrayList<PrgState> newList);
}

