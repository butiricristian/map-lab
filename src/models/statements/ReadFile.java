package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyITuple;
import models.PrgState;

import java.io.BufferedReader;

/**
 * Created by xps on 17-Nov-16.
 */
public class ReadFile implements IStatement{

    String varFile, varName;

    public ReadFile(String var_file_id, String var_name){
        varFile = var_file_id;
        varName = var_name;
    }


    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIDictionary<Integer, MyITuple<String, BufferedReader>> fileTable = state.getFileTable();
        Integer file_desc = symTable.get(varFile);
        BufferedReader file = fileTable.get(file_desc).getSecond();
        String line = file.readLine();
        if(line == null){
            symTable.put(varName, 0);
        }
        else{
            symTable.put(varName, Integer.parseInt(line));
        }
        return state;
    }
}
