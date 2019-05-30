package Repository;

import ADT.MyADTExc;
import Model.PrgState;

import java.io.IOException;

public interface IRepo {
    PrgState getCrtPrg() throws MyADTExc;
    void logPrgStateExec( PrgState state) throws IOException, MyADTExc;
    void add(PrgState state);
}
