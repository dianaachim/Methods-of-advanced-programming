package View;
import ADT.*;
import Controller.Controller;
import Expressions.ConstExp;
import Expressions.VarExp;
import Model.MyExc;
import Model.PrgState;
import Model.RunExample;
import Repository.IRepo;
import Repository.Repo;
import Statements.*;
import Model.ExitCmd;

import java.io.BufferedReader;
import java.io.IOException;


public class Interpreter {
    public static void main(String[] args) {
        //openRFile(var_f, "test.in");
        //readFile(var_f, var_c);
        //print(var_c);
        //(if var_c then readFile(var_f,var_c); print(var_c)
         //   else print(0));
        //closeFile(var_f);
        try {
            MyStack<IStmt> exeStack = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable = new MyDictionary<String, Integer>();
            MyList<Integer> out = new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();
            MyHeap heap = new MyHeap();

            IStmt ex1 = new CompStmt(
                    new openRFile("var_f", "file.txt"),
                    new CompStmt(
                            new readFile(new VarExp("var_f"), "var_c"),
                            new CompStmt(
                                    new PrintStmt(new VarExp("var_c")),
                                    new CompStmt(
                                            new IfStmt(
                                                    new VarExp("var_c"),
                                                    new CompStmt(
                                                            new readFile(new VarExp("var_f"), "var_c"),
                                                            new PrintStmt(new VarExp("var_c"))
                                                    ),
                                                    new PrintStmt(new ConstExp(0))
                                            ),
                                            new closeFile(new VarExp("var_f"))
                                    )
                            )
                    )
            );
            IStmt ex2 = new openRFile("var_f", "test.in");

            IStmt ex = new CompStmt(
                    new openRFile("var_f", "file.txt"),
                    new CompStmt(
                            new readFile(new VarExp("var_f"), "var_c"),
                            new CompStmt(
                                    new PrintStmt(new VarExp("var_c")),

                                            new IfStmt(
                                                    new VarExp("var_c"),
                                                    new CompStmt(
                                                            new readFile(new VarExp("var_f"), "var_c"),
                                                            new PrintStmt(new VarExp("var_c"))
                                                    ),
                                                    new PrintStmt(new ConstExp(0))

                                    )
                            )
                    )
            );

            PrgState prg2 = new PrgState(exeStack, symTable, out, fileTable, heap, ex2);
            PrgState prg1 = new PrgState(exeStack, symTable, out, fileTable, heap, ex);
            IRepo repo1 = new Repo("log1.txt");
            repo1.add(prg1);
            Controller ctr1 = new Controller(repo1);

            // openRFile(var_f,"test.in");
            // readFile(var_f+2,var_c);print(var_c);
            // (if var_c then readFile(var_f,var_c);print(var_c)
            //  else print(0));
            //  closeRFile(var_f)
/*
            MyStack<IStmt> exeStack2 = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable2 = new MyDictionary<String, Integer>();
            MyList<Integer> out2 = new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable2 = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();


            );
            PrgState prg2 = new PrgState(...,ex2);
            MyIRepository repo2 = new MyRepository(prg2, "log2.txt");
            Controller ctr2 = new Controller(repo2);
            IStmt ex3 = new ...;
            PrgState prg3 = new PrgState(...,ex3);
            MyIRepository repo3 = new MyRepository(prg3, "log3.txt");
            Controller ctr3 = new Controller(repo3);
            */
            TextMenu menu = new TextMenu();
            menu.addCommand(new ExitCmd("0", "exit"));
            menu.addCommand(new RunExample("1", ex1.toString(), ctr1));
            //menu.addCommand(new RunExample("2", ex2.toString(), ctr2));
            //menu.addCommand(new RunExample("3", ex3.toString(), ctr3));
            menu.show();
        } catch (MyExc e) {
            e.printStackTrace();
        }

    }
}
