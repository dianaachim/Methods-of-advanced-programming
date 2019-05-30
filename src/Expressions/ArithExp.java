package Expressions;

import ADT.MyADTExc;
import ADT.MyHeap;
import ADT.MyIDictionary;
import ADT.MyIHeap;
import Statements.MyStmtExc;

public class ArithExp extends Exp{
    private Exp e1;
    private Exp e2;
    private int op;  // 1 stands for +
                     // 2 stands for -
                     // 3 stands for *
                     // 4 stands for /
    public ArithExp(Exp ex1, Exp ex2, int operator) {
        e1 = ex1;
        e2 = ex2;
        op = operator;
    }
    public int eval(MyIDictionary<String, Integer> tbl, MyIHeap heap) throws MyExpExc, MyADTExc {
        if (op<1 || op>4)
            throw new MyExpExc("Wrong operator");
        if (op==1)
            return (e1.eval(tbl, heap) + e2.eval(tbl, heap));
        else if (op==2)
            return (e1.eval(tbl, heap) - e2.eval(tbl, heap));
        else if (op==3)
            return (e1.eval(tbl, heap) * e2.eval(tbl, heap));
        else if (e2.eval(tbl, heap)==0)
                throw new MyExpExc("Division by zero");
            return (e1.eval(tbl, heap) / e2.eval(tbl, heap));
    }
    public String toString() {
        if (op==1)
            return e1.toString() + " + " + e2.toString();
        else if (op==2)
            return e1.toString() + " - " + e2.toString();
        else if (op==3)
            return e1.toString() + " * " + e2.toString();
        else return e1.toString() + " / " + e2.toString();
    }
}
