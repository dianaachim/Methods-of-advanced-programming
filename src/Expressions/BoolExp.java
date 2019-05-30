package Expressions;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIHeap;

public class BoolExp extends Exp{
    private Exp exp1;
    private Exp exp2;
    private String op;

    public BoolExp(Exp e1, Exp e2, String o) {
        exp1 = e1;
        exp2 = e2;
        op = o;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> tbl, MyIHeap heap) throws MyExpExc, MyADTExc {
        switch (op) {
            case "<":
                if (exp1.eval(tbl, heap) < exp2.eval(tbl, heap))
                    return 1;
                else return 0;
            case "<=":
                if (exp1.eval(tbl, heap) <= exp2.eval(tbl, heap))
                    return 1;
                else return 0;
            case "==":
                if (exp1.eval(tbl, heap) == exp2.eval(tbl, heap))
                    return 1;
                else return 0;
            case "!=":
                if (exp1.eval(tbl, heap) != exp2.eval(tbl, heap))
                    return 1;
                else return 0;
            case ">":
                if (exp1.eval(tbl, heap) > exp2.eval(tbl, heap))
                    return 1;
                else return 0;
            case ">=":
                if (exp1.eval(tbl, heap) >= exp2.eval(tbl, heap))
                    return 1;
                else return 0;
            default:
                throw new MyExpExc("Invalid operand!");
        }
    }

    public String toString() {
        return "(" +  exp1.toString() + ")" + op + "(" + exp2.toString() + ")";

    }


}
