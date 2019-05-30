package Statements;

import ADT.MyADTExc;
import Expressions.MyExpExc;
import Model.PrgState;

public interface IStmt {
    String toString();
    PrgState execute(PrgState state) throws MyExpExc, MyADTExc;
}
