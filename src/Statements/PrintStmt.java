package Statements;

import ADT.MyADTExc;
import ADT.MyIList;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Exp exp;
    public PrintStmt(Exp e) {
        exp = e;
    }
    public String toString() {
        return "print(" + exp.toString() + ")";
    }
    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        MyIList<Integer> out = state.getOut();
        Integer res = exp.eval(state.getSymTable(), state.getHeap());
        out.addFirst(res);
        return state;
    }
}
