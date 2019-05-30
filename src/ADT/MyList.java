package ADT;

import java.util.LinkedList;

public class MyList<T> implements MyIList<T> {
    private LinkedList<T> list;
    public MyList() {
        list = new LinkedList<T>();
    }
    public void addFirst(T elem) {
        list.addFirst(elem);
    }
    public T removeFirst() throws MyADTExc{
        if (list.isEmpty())
            throw new MyADTExc("Empty output list");
        return list.removeFirst();
    }
    public String toString() {return list.toString();}
}
