package Expressions;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIHeap;

public class VarExp extends Exp{
    private String id;
    public VarExp(String i) {
        id = i;
    }
    public int eval(MyIDictionary<String, Integer> tbl, MyIHeap heap) throws MyADTExc{
        return tbl.get(id);
    }
    public String toString() {
        return (id);
    }
}
