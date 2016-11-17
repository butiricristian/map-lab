package repositories;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIList;
import models.ADTs.MyIStack;
import models.ADTs.MyITuple;
import models.PrgState;
import models.statements.IStatement;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;

public class PrgRepository implements IPrgRepository{

    MyIList<PrgState> programs;
    String logFilePath;

    public PrgRepository(MyIList<PrgState> progs, String filePath){
        programs = progs;
        logFilePath = filePath;
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
    public void logPrgStateExec(PrgState state){
        try {
            PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));

            MyIStack<IStatement> exeStack = state.getExeStack();
            MyIDictionary<String, Integer> symTable = state.getSymTable();
            MyIList<Integer> out = state.getOut();
            MyIDictionary<Integer, MyITuple> fileTable = state.getFileTable();

            log.println("Exe Stack:");
            log.println(exeStack);

            log.println("Symbol Table:");
            log.println(symTable);

            log.println("Out:");
            log.println(out);

            log.println("File Table:");
            log.println(fileTable);

            log.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MyIList<PrgState> getAll(){
        return programs;
    }
}
