package ADT;

public interface MyIStack <T>{
    T pop() throws MyADTExc;
    void push(T v);
    boolean isEmpty();
    String toString();
}
