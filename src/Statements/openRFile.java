package Statements;

import ADT.MyADTExc;
import ADT.MyIDictionary;
import ADT.MyTuple;
import Expressions.MyExpExc;
import Model.IdGenerator;
import Model.PrgState;

import java.io.*;

public class openRFile implements IStmt{
    private String var_file_id;
    private String filename;

    public openRFile(String fileid, String filen) {
        var_file_id=fileid;
        filename = filen;
    }

    private boolean isOpen(PrgState state) {
        MyIDictionary<Integer, MyTuple<String, BufferedReader>> fileTable = state.getFileTable();
        for (MyTuple<String, BufferedReader> item: fileTable.getValues())
            if (item.getFirst().equals(filename))
                return true;
            return false;

    }
    @Override
    public PrgState execute(PrgState state) throws MyExpExc, MyADTExc {
        if (!isOpen(state)) {
            try {
                BufferedReader bf = new BufferedReader(new FileReader(filename));
                MyTuple<String, BufferedReader> tuple = new MyTuple<String, BufferedReader>(filename, bf);
                int id = IdGenerator.generateID();
                state.getFileTable().put(id, tuple);
                MyIDictionary<String, Integer> symT = state.getSymTable();
                symT.put(var_file_id, id);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "openFile(" + "filename='" + filename + '\'' + ", varname'" + var_file_id + '\'' + ")";
    }
}
