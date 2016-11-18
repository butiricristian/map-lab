package models;

import models.ADTs.MyIDictionary;
import models.ADTs.MyIList;
import models.ADTs.MyIStack;
import models.ADTs.MyITuple;
import models.statements.IStatement;

import java.io.BufferedReader;

public class PrgState {

    MyIStack<IStatement> exeStack;
    MyIDictionary<String, Integer> symTable;
    MyIList<Integer> out;
    MyIDictionary<Integer, MyITuple<String, BufferedReader>> fileTable;
    IStatement originalProg;

    public PrgState(MyIStack<IStatement> exe, MyIDictionary<String, Integer> sym, MyIList<Integer> out, MyIDictionary<Integer, MyITuple<String, BufferedReader>> fTable, IStatement prg) throws Exception{
        exeStack = exe;
        symTable = sym;
        this.out = out;
        fileTable = fTable;
        originalProg = prg;
        try {
            exe.push(prg);
        }
        catch (Exception e){
            throw e;
        }
    }


    //getters
    public MyIStack<IStatement> getExeStack(){ return exeStack; }

    public MyIDictionary<String, Integer> getSymTable(){
        return symTable;
    }

    public MyIList<Integer> getOut(){
        return out;
    }

    public MyIDictionary<Integer, MyITuple<String, BufferedReader>> getFileTable(){
        return fileTable;
    }


    //setters
    public void setExeStack(MyIStack<IStatement> exeStack){ this.exeStack = exeStack; }

    public void setSymTable(MyIDictionary<String, Integer> symTable){ this.symTable = symTable; }

    public void setOut(MyIList<Integer> out){ this.out = out; }

    @Override
    public String toString(){
        return "Exe Stack: " + exeStack.toString() + "\n" +
                "Symbol Table: " + symTable.toString() + "\n" +
                "Out: " + out.toString() + "\n" +
                "File Table: " + fileTable.toString() + "\n";
    }
}
