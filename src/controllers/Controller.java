package controllers;

import models.ADTs.MyIList;
import models.ADTs.MyIStack;
import models.ADTs.MyList;
import models.PrgState;
import models.exceptions.FileException;
import models.statements.IStatement;
import repositories.IPrgRepository;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Controller {
    IPrgRepository repo;
    boolean flag = true;
    ExecutorService exec;

    public Controller(IPrgRepository repository){
        repo = repository;
    }

    public void oneStepForAllPrg(List<PrgState> prgList){
        prgList.forEach(prg -> {
            try {
                repo.logPrgStateExec(prg);
            } catch (FileException e) {
                System.out.println(e.getMessage());
            }
        });

        List<Callable<PrgState>> callList = prgList.stream().map((PrgState prg) -> (Callable<PrgState>)(() -> { return prg.oneStep(); })).collect(Collectors.toList());

        List<PrgState> newPrgList = null;
        try {
            newPrgList = exec.invokeAll(callList).stream().
                    map(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return null;
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }).filter(p->p!=null).collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        prgList.addAll(newPrgList);
        prgList.forEach(prg -> {
            try {
                repo.logPrgStateExec(prg);
            } catch (FileException e) {
                e.printStackTrace();
            }
        });

        repo.setPrgList((ArrayList<PrgState>)prgList);

    }

    public String executeAllSteps() throws Exception{
        String result = "";
        exec = Executors.newFixedThreadPool(2);
        //repo.serialize();
        while(true){
            try{
                List<PrgState> prgList = this.removeCompletedPrg(repo.getPrgList().getContent());
//                prog.getHeap().setContent((HashMap)conservativeGarbageCollector(prog.getSymTable().getContent().values(),
//                        prog.getHeap().getContent()));
                if(prgList.size() == 0){
                    break;
                }
                oneStepForAllPrg(prgList);
                result += prgList.toString() + "\n";
            }
            catch (Exception e){
                throw e;
            }
        }
        exec.shutdownNow();
        //repo.deserialize();
        result += repo.getPrgList().get(0).getOut().toString() + "\n";
        return result;
    }

    public void allStepGUI() throws Exception{
        exec = Executors.newFixedThreadPool(2);
        List<PrgState> prgList = removeCompletedPrg(repo.getPrgList().getContent());
        if(prgList.size() == 0){
            exec.shutdownNow();
            throw new Exception("Program done exception");
        }
        else{
            oneStepForAllPrg(prgList);
            exec.shutdownNow();
        }
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

    public MyIList<PrgState> getPrgStates(){
        return repo.getPrgList();
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

//    public void serializePrgState() throws IOException{
//        repo.serialize();
//    }

//    public void deserializePrgState() throws IOException, ClassNotFoundException {
//        repo.deserialize();
//    }

    public List<PrgState> removeCompletedPrg(List<PrgState> inPrgList){
        return inPrgList.stream().filter(p->p.isNotCompleted()).collect(Collectors.toList());
    }
}
