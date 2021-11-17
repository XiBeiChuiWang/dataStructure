package _21_30_;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty() && stack2.peek() <= x){
            stack2.push(stack2.peek());
        }else {
            stack2.push(x);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        stack2.pop();
        return stack1.pop();
    }

    public int min() {
        return stack2.peek();
    }
}
