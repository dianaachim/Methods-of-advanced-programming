package Statements;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIHeap;
import ADT.MyIStack;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

public class WhileStmt implements IStmt {
    private Exp exp;
    private IStmt stmt;

    public WhileStmt(Exp e, IStmt s) {
        exp = e;
        stmt = s;
    }

    public String toString() {
        return "while (" + exp.toString() + ") " + stmt.toString();
    }

    @Override
    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        MyIStack<IStmt> stk = state.getStack();
        MyIDictionary<String, Integer> tbl = state.getSymTable();
        MyIHeap heap = state.getHeap();

        if (exp.eval(tbl, heap) != 0) {
            stk.push(this);
            stk.push(stmt);
        }
        return state;
    }
}
