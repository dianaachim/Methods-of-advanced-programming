package Model;

public abstract class Command {
    private String key;
    private String descr;

    public Command(String k, String d) {
        key = k;
        descr = d;
    }
    public abstract  void execute();
    public String getKey() {return key;}
    public String getDescr() {return descr;}
}
