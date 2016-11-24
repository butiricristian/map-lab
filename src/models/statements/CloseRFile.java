package models.statements;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIFileTable;
import models.ADTs.MyITuple;
import models.PrgState;
import models.expressions.Expression;

import java.io.BufferedReader;

/**
 * Created by xps on 17-Nov-16.
 */
public class CloseRFile implements IStatement{
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
        return state;
    }

    @Override
    public String toString(){
        return "closeRFile(" + varFile + ")";
    }
}
