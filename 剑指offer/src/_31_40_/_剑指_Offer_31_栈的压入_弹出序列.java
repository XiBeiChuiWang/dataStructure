package _31_40_;

import java.util.Stack;

public class _剑指_Offer_31_栈的压入_弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> integers = new Stack<>();
        int index = 0;
        for (int i = 0;i < pushed.length;i++){
            integers.push(pushed[i]);
            while (!integers.isEmpty() && popped[index] == integers.peek()){
                integers.pop();
                index++;
            }
        }
        return integers.isEmpty();
    }
}
