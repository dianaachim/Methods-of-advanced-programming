package Statements;

import Model.MyExc;

public class MyStmtExc extends MyExc {
    private String message;
    public MyStmtExc (String msg) {message = msg;}
    public String getMessage() {return message; }
}
