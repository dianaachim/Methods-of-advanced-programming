package Statements;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIHeap;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

public class NewStmt implements IStmt {
    private String var_name;
    private Exp expression;

    public NewStmt(String name, Exp exp) {
        var_name = name;
        expression = exp;
    }

    public String toString() {
        return "new(" + var_name + " , " + expression.toString() + ")";
    }

    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIHeap heap = state.getHeap();
        int value = expression.eval(symTable, heap);
        int address = heap.New(value);
        symTable.put(var_name, address);
        return state;
    }
}
