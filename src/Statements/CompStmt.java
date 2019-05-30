package Statements;

import ADT.MyADTExc;
import ADT.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt snd;
    public CompStmt(IStmt f, IStmt s) {
        first = f;
        snd = s;
    }
    public String toString() {
        return "(" + first.toString() + " ; " + snd.toString() + ")";
    }
    public PrgState execute(PrgState state) throws MyADTExc

    {
        MyIStack<IStmt> stk = state.getStack();

        stk.push(snd);
        stk.push(first);
        return state;
    }
}
