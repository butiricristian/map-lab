package models;

import models.ADTs.*;
import models.statements.IStatement;

import java.io.*;

public class PrgState implements Serializable{

    MyIStack<IStatement> exeStack;
    MyIDictionary<String, Integer> symTable;
    MyIList<Integer> out;
    MyIFileTable fileTable;
    MyIHeap heap;
    IStatement originalProg;


    public PrgState(MyIStack<IStatement> exe, MyIDictionary<String, Integer> sym, MyIList<Integer> out, MyIFileTable fTable, MyIHeap heap, IStatement prg) throws Exception{
        exeStack = exe;
        symTable = sym;
        this.out = out;
        fileTable = fTable;
        this.heap = heap;
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

    public MyIFileTable getFileTable(){
        return fileTable;
    }

    public MyIHeap getHeap(){
        return heap;
    }


    //setters
    public void setExeStack(MyIStack<IStatement> exeStack){ this.exeStack = exeStack; }

    public void setSymTable(MyIDictionary<String, Integer> symTable){ this.symTable = symTable; }

    public void setOut(MyIList<Integer> out){ this.out = out; }

    public void setFileTable(MyIFileTable fTable){
        this.fileTable = fTable;
    }

    public void setHeap(MyIHeap heap){
        this.heap = heap;
    }

    @Override
    public String toString(){
        return "Exe Stack: " + exeStack.toString() + "\n" +
                "Symbol Table: " + symTable.toString() + "\n" +
                "Out: " + out.toString() + "\n" +
                "File Table: " + fileTable.toString() + "\n" +
                "Heap:  " + heap.toString() + "\n";
    }
}
