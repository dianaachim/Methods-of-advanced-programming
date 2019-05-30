package Statements;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIStack;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;
    public AssignStmt(String ID, Exp e) {
        id = ID;
        exp = e;
    }
    public String toString() {
        return id + "=" + exp.toString();
    }
    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        MyIDictionary<String, Integer> symTbl = state.getSymTable();
        int res = exp.eval(symTbl, state.getHeap());
        symTbl.put(id, res);
        return state;
    }
}
