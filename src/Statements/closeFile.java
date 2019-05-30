package Statements;

import ADT.MyADTExc;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.MyExc;
import Model.PrgState;

import java.io.IOException;

public class closeFile implements IStmt{
    private Exp exp_file_id;

    public closeFile(Exp e) {
        exp_file_id = e;
    }

    public String toString(){
        return "closeFile(" + exp_file_id.toString() + ")";
    }
    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        try {
            int eval_exp = exp_file_id.eval(state.getSymTable(), state.getHeap());
            if (state.getFileTable().get(eval_exp)!=null) {
                state.getFileTable().get(eval_exp).getSecond().close();
                state.getFileTable().remove(eval_exp);
            }
            else throw new MyStmtExc("File not found in symbol Table!");
        } catch (IOException | MyStmtExc e) {
            e.printStackTrace();
        }
        return state;
    }
}
