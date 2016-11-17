package controllers;

import models.ADTs.MyIList;
import models.ADTs.MyIStack;
import models.PrgState;
import models.statements.IStatement;
import repositories.IPrgRepository;

public class Controller {
    IPrgRepository repo;
    boolean flag = false;

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

    public void executeAllSteps() throws Exception{
        PrgState prog = repo.getCrtProgram();
        MyIStack<IStatement> exeStack = prog.getExeStack();
        while(!exeStack.isEmpty()){
            try{
                PrgState resState = executeOneStep(prog);
                if(flag) {
                    System.out.println(resState);
                }
                repo.logPrgStateExec(resState);
            }
            catch (Exception e){
                throw e;
            }
        }
        System.out.println(prog.getOut());

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
}
