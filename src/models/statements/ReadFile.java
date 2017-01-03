package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIFileTable;
import models.ADTs.MyITuple;
import models.PrgState;
import models.expressions.Expression;

import java.io.BufferedReader;
import java.io.Serializable;

public class ReadFile implements IStatement, Serializable{

    Expression varFile;
    String varName;

    public ReadFile(Expression var_file_id, String var_name){
        varFile = var_file_id;
        varName = var_name;
    }


    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIFileTable fileTable = state.getFileTable();
        Integer file_desc = varFile.eval(symTable, state.getHeap());
        BufferedReader file = fileTable.get(file_desc).getSecond();
        String line = file.readLine();
        if(line == null){
            symTable.put(varName, 0);
        }
        else{
            symTable.put(varName, Integer.parseInt(line));
        }
        return null;
    }

    @Override
    public String toString(){
        return "readFile(" + varFile + ", " + varName + ")";
    }
}
