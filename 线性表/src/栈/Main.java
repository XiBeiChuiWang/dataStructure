package 栈;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MinStack<Integer> integerMinStack = new MinStack<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        integerMinStack.push(1);
        integerMinStack.push(2);
        integerMinStack.push(3);
        integerMinStack.push(4);
        integerMinStack.push(5);
        System.out.println(integerMinStack.getMin());
        System.out.println(integerMinStack.top());
        System.out.println(integerMinStack.pop());
        System.out.println(integerMinStack.getMin());
        System.out.println(integerMinStack.top());
    }
}
