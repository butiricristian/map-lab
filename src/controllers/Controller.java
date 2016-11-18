package controllers;

import models.ADTs.MyIList;
import models.ADTs.MyIStack;
import models.PrgState;
import models.statements.IStatement;
import repositories.IPrgRepository;

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
        catch (Exception e){
            throw e;
        }
    }

    public String executeAllSteps() throws Exception{
        String result = "";
        PrgState prog = repo.getCrtProgram();
        MyIStack<IStatement> exeStack = prog.getExeStack();
        while(!exeStack.isEmpty()){
            try{
                PrgState resState = executeOneStep(prog);
                if(flag) {
                    // System.out.println(resState);
                    result += resState.toString();
                }
                repo.logPrgStateExec(resState);
            }
            catch (Exception e){
                throw e;
            }
        }
        // System.out.println(prog.getOut());
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

    public void setFlag(boolean cond){
        flag = cond;
    }

    public boolean getFlag(){
        return flag;
    }

    public void changeLogFile(String fileName){
        repo.setLogFilePath(fileName);
    }
}
