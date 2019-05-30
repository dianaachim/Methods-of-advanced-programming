package ADT;

import Model.MyExc;

public class MyADTExc extends MyExc {
    private String message;
    public MyADTExc (String msg) {message = msg;}
    public String getMessage() {return message; }
}
