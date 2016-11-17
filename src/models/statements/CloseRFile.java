package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyITuple;
import models.PrgState;

import java.io.BufferedReader;

/**
 * Created by xps on 17-Nov-16.
 */
public class CloseRFile implements IStatement{
    String varFile;

    public CloseRFile(String var_file_id){
        varFile = var_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIDictionary<Integer, MyITuple<String, BufferedReader>> fileTable = state.getFileTable();
        Integer file_desc = symTable.get(varFile);
        BufferedReader file = fileTable.get(file_desc).getSecond();
        file.close();
        fileTable.remove(file_desc);
        return state;
    }
}
