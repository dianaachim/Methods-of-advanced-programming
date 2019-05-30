package Model;
import Controller.Controller;
import Model.MyExc;

import java.io.IOException;

public class RunExample extends Command {
    private Controller ctr;
    public RunExample(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() {
        try{
            ctr.allStep(); }
        catch (MyExc | IOException e) {
            e.printStackTrace();
        }
    }

}
