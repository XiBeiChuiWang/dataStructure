package 栈;

import java.util.Comparator;
import java.util.Stack;

public class MinStack<E>{
    private Stack<E> stack;
    private Stack<E> stackmin;
    private Comparator comparator;

    public MinStack() {
        stack = new Stack<>();
        stackmin = new Stack<>();
    }

    public MinStack(Comparator comparator) {
        this();
        this.comparator = comparator;
    }

    public void push(E e){
        stack.push(e);
        if (stackmin.isEmpty()){
            stackmin.push(e);
        } else {
            E peek = stackmin.peek();
            if (compare(peek,e) >= 0){
                stackmin.push(e);
            } else {
                stackmin.push(peek);
            }
        }
    }

    public E pop(){
        stackmin.pop();
        return stack.pop();
    }

    public E top(){
        return stack.peek();
    }

    public E getMin(){
        return stackmin.peek();
    }

    private int compare(E e1,E e2){
        return comparator == null ? ((Comparable)e1).compareTo(e2) : comparator.compare(e1,e2);
    }
}
