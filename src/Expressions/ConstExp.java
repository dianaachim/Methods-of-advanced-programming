package Expressions;

import ADT.MyIDictionary;
import ADT.MyIHeap;

public class ConstExp extends Exp {
    private int number;
    public ConstExp(int nr) {
        number = nr;
    }
    public int eval (MyIDictionary<String, Integer> tbl, MyIHeap heap) {
        return number;
    }
    public String toString(){
        return (Integer.toString(number));
    }
}
