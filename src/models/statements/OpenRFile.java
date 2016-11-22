package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIFileTable;
import models.ADTs.MyITuple;
import models.ADTs.MyTuple;
import models.PrgState;
import models.exceptions.FileException;

import java.io.BufferedReader;
import java.io.FileReader;

public class OpenRFile implements IStatement {

    String varFileName, fileName;

    public OpenRFile(String var_file_id, String fileName){
        this.varFileName = var_file_id;
        this.fileName = fileName;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIFileTable fileTable = state.getFileTable();
        for(Integer x : fileTable.keySet()) {
            if (fileTable.get(x).getFirst() == fileName) {
                throw new FileException("File already exists");
            }
        }
        BufferedReader fl = new BufferedReader(new FileReader(fileName));
        Integer prevKey = fileTable.add(new MyTuple(fileName, fl));
        state.getSymTable().put(varFileName, prevKey);
        prevKey++;
        return state;
    }

    @Override
    public String toString(){
        return "openRFile(" + varFileName + ", " + fileName + ")";
    }
}
