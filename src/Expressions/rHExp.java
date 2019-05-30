package Expressions;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyIHeap;

public class rHExp extends Exp {
    private String var_name;

    public rHExp(String name) {
        var_name = name;
    }

    public String toString() {
        return "read(" + var_name + ")";
    }

    public int eval(MyIDictionary<String, Integer> tbl, MyIHeap heap) throws MyExpExc, MyADTExc {
        int address = tbl.get(var_name);
        return heap.Read(address);
    }
}
