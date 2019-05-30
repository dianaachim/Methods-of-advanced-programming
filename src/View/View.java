package View;

import ADT.*;
import Controller.Controller;
import Expressions.ArithExp;
import Expressions.ConstExp;
import Expressions.VarExp;
import Expressions.rHExp;
import Model.MyExc;
import Model.PrgState;
import Repository.Repo;
import Statements.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class View {
    public static void main(String[] args) {
        //v=2 print(v)
        //a=2-2; (if a then v=2 else v=3); print(v)
        try {
            /*ConstExp con = new ConstExp(2);
            VarExp var = new VarExp("v");
            AssignStmt asgn = new AssignStmt("v", con);
            PrintStmt prt = new PrintStmt(var);
            CompStmt cstmt = new CompStmt(asgn, prt);
            //System.out.print(cstmt.toStr());

            VarExp var = new VarExp("a");
            ConstExp con1 = new ConstExp(2);
            ConstExp con2 = new ConstExp(3);
            ArithExp arithexp = new ArithExp(con1, con1, 2);
            AssignStmt asgn = new AssignStmt("a", arithexp);
            VarExp var2 = new VarExp("v");
            AssignStmt asg1 = new AssignStmt("v", con1);
            AssignStmt asg2 = new AssignStmt("v", con2);
            IfStmt iff = new IfStmt(var, asg1, asg2);
            PrintStmt prt = new PrintStmt(var2);

            CompStmt cstmt1 = new CompStmt(iff, prt);
            CompStmt cstmt = new CompStmt(asgn, cstmt1);
            //System.out.println(cstmt.toString());


            //v=10;new(v,20);new(a,22);print(v)
            //v=10;new(v,20);new(a,22);print(100+rH(v));print(100+rH(a))
            //v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a))
            //v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a)); a=0
            ConstExp con1 = new ConstExp(10);
            VarExp var1 = new VarExp("v");
            AssignStmt asgn = new AssignStmt("v", con1);
            ConstExp con2 = new ConstExp(20);
            NewStmt news1 = new NewStmt("v", con2);
            VarExp var2 = new VarExp("a");
            ConstExp con3 = new ConstExp(22);
            NewStmt news2 = new NewStmt("a", con3);

            PrintStmt prt = new PrintStmt(var1);
            CompStmt co1 = new CompStmt(news2, prt);
            CompStmt  co2 = new CompStmt(news1, co1);
            CompStmt co3 = new CompStmt(asgn, co2);

            rHExp rh1 = new rHExp("a");
            rHExp rh2 = new rHExp("v");
            ConstExp cons = new ConstExp(100);
            ArithExp arith1 = new ArithExp(cons, rh2, 1);
            ArithExp arith2 = new ArithExp(cons, rh1, 1);
            PrintStmt print1 = new PrintStmt(arith1);
            PrintStmt print2 = new PrintStmt(arith2);
            CompStmt com1 = new CompStmt(print1, print2);
            CompStmt com2 = new CompStmt(news2, com1);
            CompStmt com3 = new CompStmt(news1, com2);
            CompStmt com4 = new CompStmt(asgn, com3);

            ConstExp con4 = new ConstExp(30);
            wHStmt wH = new wHStmt("a", con4);
            PrintStmt prt1 = new PrintStmt(var2);
            ConstExp con5 = new ConstExp(0);
            AssignStmt asgn2 = new AssignStmt("a", con5);

            PrintStmt prt2 = new PrintStmt(rh1);

            CompStmt compp1 = new CompStmt(prt1, prt2);
            CompStmt compp2 = new CompStmt(wH, compp1);
            CompStmt compp3 = new CompStmt(news2, compp2);
            CompStmt compp4 = new CompStmt(news1, compp3);
            CompStmt compp5 = new CompStmt(asgn, compp4);

            CompStmt comp1 = new CompStmt(prt2, asgn2);
            CompStmt comp2 = new CompStmt(prt1, comp1);
            CompStmt comp3 = new CompStmt(wH, comp2);
            CompStmt comp4 = new CompStmt(news2, comp3);
            CompStmt comp5 = new CompStmt(news1, comp4);
            CompStmt comp6 = new CompStmt(asgn, comp5);

            MyStack<IStmt> exeStack = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable = new MyDictionary<String, Integer>();
            MyList<Integer> out = new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();
            MyHeap heap = new MyHeap();
            PrgState state1 = new PrgState(exeStack, symTable, out, fileTable, heap, co3);

            MyStack<IStmt> exeStack1 = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable1 = new MyDictionary<String, Integer>();
            MyList<Integer> out1 = new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable1 = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();
            MyHeap heap1 = new MyHeap();
            PrgState state2 = new PrgState(exeStack1, symTable1, out1, fileTable1, heap1, com4);

            MyStack<IStmt> exeStack2 = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable2 = new MyDictionary<String, Integer>();
            MyList<Integer> out2= new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable2 = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();
            MyHeap heap2 = new MyHeap();
            PrgState state3 = new PrgState(exeStack2, symTable2, out2, fileTable2, heap2, compp5);

            MyStack<IStmt> exeStack3 = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable3 = new MyDictionary<String, Integer>();
            MyList<Integer> out3 = new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable3 = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();
            MyHeap heap3 = new MyHeap();
            PrgState state4 = new PrgState(exeStack3, symTable3, out3, fileTable3, heap3, comp6);

            Repo repo1 = new Repo("file.txt");
            repo1.add(state1);
            Repo repo2 = new Repo("file.txt");
            repo2.add(state2);
            Repo repo3 = new Repo("file.txt");
            repo3.add(state3);
            Repo repo4 = new Repo("file.txt");
            repo4.add(state4);
            Controller ctrl1 = new Controller(repo1);
            Controller ctrl2 = new Controller(repo2);
            Controller ctrl3 = new Controller(repo3);
            Controller ctrl4 = new Controller(repo4);
            ctrl1.allStep();
            ctrl2.allStep();
            ctrl3.allStep();
            ctrl4.allStep();
            */
            openRFile file = new openRFile("var_f", "file.txt");

            ConstExp con1 = new ConstExp(6);
            ConstExp con2 = new ConstExp(4);
            ConstExp con3 = new ConstExp(1);
            VarExp var = new VarExp("v");
            AssignStmt asgn1 = new AssignStmt("v", con1);
            ArithExp arth1 = new ArithExp(var, con2, 2);
            PrintStmt prt = new PrintStmt(var);
            ArithExp arth2 = new ArithExp(var, con3, 2);
            AssignStmt asgn2 = new AssignStmt("v", arth2);
            CompStmt comp1 = new CompStmt(prt, asgn2);
            WhileStmt whl  = new WhileStmt(arth1, comp1);
            CompStmt comp = new CompStmt(file, whl);
            //CompStmt comp2 = new CompStmt(prt, comp);
            CompStmt comp2 = new CompStmt(whl, prt);
            CompStmt comp3 = new CompStmt(asgn1, comp2);

            MyStack<IStmt> exeStack = new MyStack<IStmt>();
            MyDictionary<String, Integer> symTable = new MyDictionary<String, Integer>();
            MyList<Integer> out = new MyList<Integer>();
            MyDictionary<Integer, MyTuple<String, BufferedReader>> fileTable = new MyDictionary<Integer, MyTuple<String, BufferedReader>>();
            MyHeap heap = new MyHeap();
            PrgState state = new PrgState(exeStack, symTable, out, fileTable, heap, comp3);

            Repo repo = new Repo("file.txt");
            repo.add(state);
            Controller ctrl = new Controller(repo);

            ctrl.allStep();

        } catch (MyExc | IOException exc) {
            exc.printStackTrace();
        }
    }
}
