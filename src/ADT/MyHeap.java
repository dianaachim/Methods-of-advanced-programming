package ADT;

import java.util.HashMap;

public class MyHeap implements MyIHeap {
    private HashMap<Integer, Integer> heap;
    private int location;

    public MyHeap() {
        heap = new HashMap<Integer, Integer>();
        location = 1;
    }
    public String toString() {return heap.toString();}

    @Override
    public int New(int value) {
        int address = location;
        location++;
        heap.put(address, value);
        return address;
    }

    @Override
    public int Read(int address) {
        return heap.get(address);
    }

    @Override
    public void Update(int address, int value) {
        heap.remove(address);
        heap.put(address, value);
    }

    public void setContent(HashMap<Integer, Integer> map) {
        heap = map;
    }

    public HashMap<Integer, Integer> getContent() {
        return heap;
    }
}
