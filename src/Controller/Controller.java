package Controller;

import ADT.*;
import Expressions.MyExpExc;
import Expressions.VarExp;
import Model.MyExc;
import Model.PrgState;
import Repository.IRepo;
import Statements.IStmt;
import Statements.closeFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Controller {
    private IRepo repo;
    private String flag;

    public Controller(IRepo rep) {
        repo = rep;
        //setFlag(f);
    }

    public Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet().stream().filter(e -> symTableValues.contains(e.getKey())).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    /*
        public void fileCloser(HashMap<String, Integer> symTable, HashMap<Integer, MyTuple<String, BufferedReader>> fileTable, PrgState state) {
            HashMap<String, Integer> files = symTable.entrySet().stream().filter(
                    e->fileTable.containsKey(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Entry::getValue));
            )
        }
    */
    public PrgState oneStep(PrgState state) throws MyCtrlExc, MyADTExc, MyExpExc {
        MyIStack<IStmt> stk = state.getStack();
        if (stk.isEmpty()) throw new MyCtrlExc("The execution Stack is empty!");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }

    public void setFlag(String value) {
        this.flag = value;
    }

    public void allStep() throws MyExc, IOException {
        try {
            PrgState prg = repo.getCrtPrg();

            try {
                while (!prg.getStack().isEmpty()) {
                    PrgState p = oneStep(prg);

                    p.getHeap().setContent((HashMap<Integer, Integer>) conservativeGarbageCollector(p.getSymTable().getContent(), p.getHeap().getContent()));

                    System.out.println("ExeStack: \n");
                    System.out.println(p.getStack().toString());
                    System.out.println("Symbol Table: \n");
                    System.out.println(p.getSymTable().toString());
                    System.out.println("Out: \n");
                    System.out.println(p.getOut().toString());
                    System.out.println("File Table: \n");
                    System.out.println(p.getFileTable().toString());
                    System.out.println("Heap: \n");
                    System.out.println(p.getHeap().toString());

                    repo.logPrgStateExec(prg);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Collection<Integer> fileTblKeys = prg.getFileTable().keys();
                MyIDictionary<String, Integer> symTable = prg.getSymTable();
                MyIDictionary<Integer, MyTuple<String, BufferedReader>> fileTable = prg.getFileTable();
                List<Map.Entry<String, Integer>> keys = symTable.getDict().entrySet().stream().filter(file -> fileTblKeys.contains(file.getValue())).collect(Collectors.toList());
                for (Map.Entry<String, Integer> entry : keys) {
                    if (fileTable.containsKey(entry.getValue()))
                        new closeFile(new VarExp(entry.getKey())).execute(prg);
                }
                //if (flag.equals("on")) {
                    //System.out.println(prg.toString());

                repo.logPrgStateExec(prg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
