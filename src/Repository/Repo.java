package Repository;

import ADT.MyADTExc;
import ADT.MyList;
import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Repo implements IRepo{
    private MyList<PrgState> states;
    private String logFilePath;
    public Repo(String filePath) {
        states = new MyList<PrgState>();
        logFilePath = filePath;
    }
    public PrgState getCrtPrg() throws MyADTExc{
        return states.removeFirst();
    }
    public void add(PrgState state) {
        states.addFirst(state);
    }

    public void logPrgStateExec(PrgState state) throws IOException, MyADTExc{
        try {
            FileWriter fw = new FileWriter(logFilePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter logFile = new PrintWriter(bw);
            logFile.println("ExeStack: \n");
            logFile.println(state.getStack().toString());
            logFile.println("Symbol Table: \n");
            logFile.println(state.getSymTable().toString());
            logFile.println("Out: \n");
            logFile.println(state.getOut().toString());
            logFile.println("File Table: \n");
            logFile.println(state.getFileTable().toString());
            logFile.println("Heap: \n");
            logFile.println(state.getHeap().toString());
            logFile.close();
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
    }
}
