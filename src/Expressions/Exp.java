package Expressions;

import ADT.MyADTExc;
import ADT.MyHeap;
import ADT.MyIDictionary;
import ADT.MyIHeap;

abstract public class Exp {
    public abstract int eval(MyIDictionary<String, Integer> tbl, MyIHeap heap) throws MyExpExc, MyADTExc;
    public abstract String toString();
}
