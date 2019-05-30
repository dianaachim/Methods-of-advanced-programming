package ADT;

import java.util.Stack;

public class MyStack <T> implements MyIStack<T>{
    private Stack<T> stack;
    public MyStack() {
        stack = new Stack<T>();
    }
    public T pop() throws MyADTExc{
        if (stack.isEmpty())
            throw new MyADTExc("Empty execution stack");
        return stack.pop();
    }
    public void push(T v) {
        stack.push(v);
    }
    public boolean isEmpty() {return stack.isEmpty();}
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T v: stack) {
            s.append(v.toString()).append("\n");
        }
        return s.toString();
    }
}
