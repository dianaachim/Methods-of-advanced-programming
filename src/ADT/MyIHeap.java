package ADT;

import java.util.HashMap;

public interface MyIHeap{
    String toString();
    int New(int value);
    int Read(int address);
    void Update(int address, int value);
    void setContent(HashMap<Integer, Integer> map);
    HashMap<Integer, Integer> getContent();
}
