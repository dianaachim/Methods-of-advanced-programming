package ADT;

public interface MyIList<T> {
    void addFirst(T elem);
    T removeFirst()throws MyADTExc;
    String toString();
}
