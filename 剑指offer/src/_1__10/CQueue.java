package _1__10;

import java.util.Stack;

class CQueue {

    private Stack stack1;
    private Stack stack2;
    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if (stack2.size() == 0){
            if (stack1.size() != 0){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return (int) stack2.pop();
            }
        }else {
            return (int) stack2.pop();
        }
        return -1;
    }
}