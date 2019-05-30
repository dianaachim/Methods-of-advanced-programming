package Statements;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIHeap;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

public class wHStmt implements IStmt {
    private String var_name;
    private Exp expression;

    public wHStmt(String name, Exp exp) {
        var_name = name;
        expression = exp;
    }

    public String toString() {
        return "wH(" + var_name + " , " + expression.toString() + ")";
    }

    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        MyIDictionary<String, Integer> dict = state.getSymTable();
        MyIHeap heap = state.getHeap();
        int value = expression.eval(dict, heap);
        int address = dict.get(var_name);
        heap.Update(address, value);
        return state;
    }
}
