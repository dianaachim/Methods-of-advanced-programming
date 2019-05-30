package Statements;

import ADT.MyADTExc;
import ADT.MyIStack;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;
    public IfStmt(Exp e, IStmt t, IStmt el) {
        exp = e;
        thenS = t;
        elseS = el;
    }
    public String toString() {
        return "IF (" + exp.toString() + ") THEN (" + thenS.toString() + " ) ELSE (" + elseS.toString() + " )";
    }
    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        MyIStack<IStmt> exeStk = state.getStack();

        if (exp.eval(state.getSymTable(), state.getHeap()) != 0) {
            exeStk.push(thenS);
        }
        else {
            exeStk.push(elseS);
        }
        return state;
    }
}
