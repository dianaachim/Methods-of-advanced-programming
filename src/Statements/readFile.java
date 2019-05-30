package Statements;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyTuple;
import Expressions.Exp;
import Expressions.MyExpExc;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.IOException;

public class readFile implements IStmt {
    private Exp exp_file_id;
    private String var_name;

    public readFile(Exp file_id, String name) {
        exp_file_id = file_id;
        var_name = name;
    }
    public String toString() {
        return "readFile(" + exp_file_id.toString() + " , " + var_name + ")";
    }
    public PrgState execute(PrgState state) {
        String line = null;
        try {
            MyIDictionary<Integer, MyTuple<String, BufferedReader>> tbl = state.getFileTable();
            int eval_exp = exp_file_id.eval(state.getSymTable(), state.getHeap());
            line = tbl.get(eval_exp).getSecond().readLine();


        } catch (IOException | NullPointerException | MyADTExc | MyExpExc e) {
            e.printStackTrace();
        }
        if (line.length() == 0) {
            state.getSymTable().put(var_name, 0);
            return state;
        }
        try {
            Integer result = Integer.parseInt(line);
            state.getSymTable().put(var_name, result);
        } catch (Exception e) {
            System.out.println("debug: " + line);
        }

        return state;
    }

}
