package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyITuple;
import models.ADTs.MyTuple;
import models.PrgState;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by xps on 17-Nov-16.
 */
public class OpenRFile implements IStatement {

    String varFileName, fileName;
    Integer prevKey = 1;

    public OpenRFile(String var_file_id, String fileName){
        this.varFileName = var_file_id;
        this.fileName = fileName;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<Integer, MyITuple> fileTable = state.getFileTable();
        for(Integer x : fileTable.keySet()) {
            if (fileTable.get(x).getFirst() == fileName) {
                throw new Exception("File already exists");
            }
        }
        BufferedReader fl = new BufferedReader(new FileReader(fileName));
        fileTable.put(prevKey, new MyTuple(fileName, fl));
        prevKey++;
        return state;
    }
}
