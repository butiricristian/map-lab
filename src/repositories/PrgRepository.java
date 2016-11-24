package repositories;

import models.ADTs.*;
import models.PrgState;
import models.exceptions.FileException;
import models.statements.IStatement;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;

public class PrgRepository implements IPrgRepository{

    MyIList<PrgState> programs;
    String logFilePath;
    boolean logFileOpened;

    public PrgRepository(MyIList<PrgState> progs, String filePath){
        programs = progs;
        logFilePath = filePath;
        logFileOpened = false;
    }

    @Override
    public void addProgram(PrgState prg){
        programs.add(prg);
    }

    @Override
    public PrgState getCrtProgram() {
        return programs.get(0);
    }

    @Override
    public boolean isEmpty(){
        return programs.isEmpty();
    }

    @Override
    public void removeAll(){
        programs.removeAll();
    }

    @Override
    public void logPrgStateExec(PrgState state) throws FileException {
        try {
            PrintWriter log;
            if(logFileOpened == true) {
                log = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            }
            else
            {
                log = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, false)));
                logFileOpened = true;
            }

            MyIStack<IStatement> exeStack = state.getExeStack();
            MyIDictionary<String, Integer> symTable = state.getSymTable();
            MyIList<Integer> out = state.getOut();
            MyIFileTable fileTable = state.getFileTable();

            log.println("Exe Stack:");
            log.println(exeStack.toString().replace("[", "").replace("]", ""));

            log.println("Symbol Table:");
            log.println(symTable);

            log.println("Out:");
            log.println(out);

            log.println("File Table:");
            log.println(fileTable);

            log.println();

            log.close();
        } catch (IOException e) {
            throw new FileException("File not found");
        }

    }

    public MyIList<PrgState> getAll(){
        return programs;
    }

    @Override
    public void setLogFilePath(String newPath){
        logFilePath = newPath;
    }
}
