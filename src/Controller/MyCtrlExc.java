package Controller;

import Model.MyExc;

public class MyCtrlExc extends MyExc {
    private String message;
    public MyCtrlExc (String msg) {message = msg;}
    public String getMessage() {return message; }
}
