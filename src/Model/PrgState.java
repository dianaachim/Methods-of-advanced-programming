package Model;

import ADT.*;
import Statements.IStmt;

import java.io.BufferedReader;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIList<Integer> out;
    private MyIDictionary<Integer, MyTuple<String, BufferedReader>> fileTable;
    private MyIHeap heap;
    private IStmt originalProgram;
    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Integer> symtbl, MyIList<Integer> ot, MyIDictionary<Integer, MyTuple<String, BufferedReader>> fileT, MyIHeap heapp, IStmt prg) {
        exeStack = stk;
        symTable = symtbl;
        out = ot;
        fileTable=fileT;
        originalProgram = prg;
        heap = heapp;
        stk.push(prg);
    }
    public MyIStack<IStmt> getStack() {
        return exeStack;
    }
    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }
    public MyIList<Integer> getOut() {
        return out;
    }
    public IStmt getOriginalPrg() {
        return originalProgram;
    }
    public void setStack(MyIStack<IStmt> stk) {
        exeStack = stk;
    }
    public void setSymTable(MyIDictionary<String, Integer> symtbl) {
        symTable = symtbl;
    }
    public void setOut(MyIList<Integer> olist) {
        out = olist;
    }
    public void setOriginalProgram(IStmt oprg) {
        originalProgram = oprg;
    }

    public MyIDictionary<Integer, MyTuple<String, BufferedReader>> getFileTable() {
        return fileTable;
    }

    public void setFileTable(MyIDictionary<Integer, MyTuple<String, BufferedReader>> fileTable) {
        this.fileTable = fileTable;
    }

    public MyIHeap getHeap() {
        return heap;
    }

    public void setHeap(MyIHeap heap) {
        this.heap = heap;
    }
}
