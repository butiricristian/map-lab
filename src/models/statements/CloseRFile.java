package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIFileTable;
import models.ADTs.MyITuple;
import models.PrgState;
import models.expressions.Expression;

import java.io.BufferedReader;
import java.io.Serializable;

public class CloseRFile implements IStatement, Serializable{
    Expression varFile;

    public CloseRFile(Expression var_file_id){
        varFile = var_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIFileTable fileTable = state.getFileTable();
        Integer file_desc = varFile.eval(symTable, state.getHeap());
        BufferedReader file = fileTable.get(file_desc).getSecond();
        file.close();
        fileTable.remove(file_desc);
        return null;
    }

    @Override
    public String toString(){
        return "closeRFile(" + varFile + ")";
    }
}
