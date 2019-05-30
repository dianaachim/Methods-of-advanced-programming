package ADT;

import Model.MyExc;

import java.util.Collection;
import java.util.HashMap;

public interface MyIDictionary <T1, T2>{
    void put(T1 key, T2 value);
    T2 get(T1 key) throws MyADTExc;
    Iterable<T2> getValues();
    String toString();
    void remove(T1 key);
    Collection<T2> getContent();
    Collection<T1> keys();
    HashMap<T1, T2> getDict();
    boolean containsKey(T1 key);
}
