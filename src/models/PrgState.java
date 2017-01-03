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
    Integer id;


    public PrgState(Integer id, MyIStack<IStatement> exe, MyIDictionary<String, Integer> sym, MyIList<Integer> out, MyIFileTable fTable, MyIHeap heap, IStatement prg) throws Exception{
        exeStack = exe;
        symTable = sym;
        this.out = out;
        fileTable = fTable;
        this.heap = heap;
        originalProg = prg;
        this.id = id;
        try {
            exe.push(prg);
        }
        catch (Exception e){
            throw e;
        }
    }


    //getters
    public Integer getId(){
        return id;
    }

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
    public void setId(Integer newId){
        id = newId;
    }

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
        return "id: " + id.toString() + "\n" +
                "Exe Stack: " + exeStack.toString() + "\n" +
                "Symbol Table: " + symTable.toString() + "\n" +
                "Out: " + out.toString() + "\n" +
                "File Table: " + fileTable.toString() + "\n" +
                "Heap:  " + heap.toString() + "\n";
    }

    public boolean isNotCompleted(){
        return !exeStack.isEmpty();
    }

    public PrgState oneStep() throws Exception{
        if(exeStack.isEmpty()){
            throw new Exception("The stack is empty");
        }
        IStatement stmt = exeStack.pop();
        try{
            return stmt.execute(this);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
