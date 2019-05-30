package Expressions;

import Model.MyExc;

public class MyExpExc extends MyExc {
    private String message;
    public MyExpExc (String msg) {message = msg;}
    public String getMessage() {return message; }
}
