package ADT;

public class MyTuple <T1, T2> implements MyITuple{
    private T1 first;
    private T2 second;

    public MyTuple(T1 frst, T2 s) {
        first = frst;
        second = s;
    }
    public T1 getFirst() {
        return first;
    }
    public T2 getSecond() { return second;}
    public String toString() {
        return "("+ first.toString() + " , " + second.toString() + ")";
    }
}
