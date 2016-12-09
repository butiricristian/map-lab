package controllers;

import models.ADTs.MyIList;
import models.ADTs.MyIStack;
import models.PrgState;
import models.statements.IStatement;
import repositories.IPrgRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    IPrgRepository repo;
    boolean flag = true;

    public Controller(IPrgRepository repository){
        repo = repository;
    }

    public PrgState executeOneStep(PrgState state) throws Exception{
        MyIStack<IStatement> exeStack = state.getExeStack();
        if(exeStack.isEmpty()){
            throw new Exception("The stack is empty");
        }
        IStatement stmt = exeStack.pop();
        try{
            return stmt.execute(state);
        }
        catch (Exception e) {
            throw e;
        }
    }

    public String executeAllSteps() throws Exception{
        String result = "";
        PrgState prog = repo.getCrtProgram();
        MyIStack<IStatement> exeStack = prog.getExeStack();
        repo.serialize();
        while(!exeStack.isEmpty()){
            try{
                executeOneStep(prog);
                if(flag) {
                    // System.out.println(resState);
                    result += prog.toString() + "\n";
                }
                prog.getHeap().setContent((HashMap)conservativeGarbageCollector(prog.getSymTable().getContent().values(),
                        prog.getHeap().getContent()));
                repo.logPrgStateExec(prog);
            }
            catch (Exception e){
                throw e;
            }
        }
        // System.out.println(prog.getOut());
        repo.deserialize();
        result += prog.getOut().toString();
        return result;
    }

    public void addToRepo(PrgState pr){
        repo.addProgram(pr);
    }

    public void clearRepo(){
        if(!repo.isEmpty()){
            repo.removeAll();
        }
    }

    public Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap){
        return heap.entrySet().stream().
                filter(e -> symTableValues.contains(e.getKey())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void setFlag(boolean cond){
        flag = cond;
    }

    public boolean getFlag(){
        return flag;
    }

    public void changeLogFile(String fileName){
        repo.setLogFilePath(fileName);
    }

    public void serializePrgState() throws IOException{
        repo.serialize();
    }

    public void deserializePrgState() throws IOException, ClassNotFoundException {
        repo.deserialize();
    }

}
