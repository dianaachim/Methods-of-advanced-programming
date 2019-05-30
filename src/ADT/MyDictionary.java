package ADT;



import java.util.Collection;
import java.util.HashMap;

public class MyDictionary<T1, T2> implements MyIDictionary<T1, T2> {
    private HashMap<T1, T2> dict;
    public MyDictionary() {
        dict = new HashMap<T1, T2>();
    }
    public void put(T1 key, T2 value) {
        dict.put(key, value);
    }
    public T2 get(T1 key) throws MyADTExc {
        if (dict.containsKey(key))
            return dict.get(key);
        else
            throw new MyADTExc("Inexistent key");
    }
    public Iterable<T2> getValues() {return dict.values();}
    public Collection<T2> getContent() {return dict.values();}
    public String toString() {return dict.toString(); }
    public void remove (T1 key) {dict.remove(key);}
    public Collection<T1> keys() {return dict.keySet();}
    public HashMap<T1, T2> getDict() {return dict;}
    public boolean containsKey(T1 key) {return dict.containsKey(key);}

}