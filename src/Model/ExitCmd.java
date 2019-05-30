package Model;

public class ExitCmd extends Command {
    public ExitCmd(String key, String descr) {super(key, descr);}
    public void execute() {System.exit(0);}
}
