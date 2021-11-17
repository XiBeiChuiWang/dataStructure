package 每日一题._3_;

import java.util.Stack;

public class _1006_笨阶乘 {
    public int clumsy(int N) {
        if (N < 0) return -1;
        Stack<Integer> integers = new Stack<>();
        integers.push(N);
        int index = 0;
        N--;
        while (N > 0){
            switch (index % 4){
                case 0 : {
                    integers.push(integers.pop() * N);
                    break;
                }
                case 1 : {
                    integers.push(integers.pop() / N);
                    break;
                }
                case 2 : {
                    integers.push(N);
                    break;
                }
                case 3 : {
                    integers.push(-N);
                    break;
                }
            }
            index++;
            N--;
        }
        int ans = 0;
        while (!integers.isEmpty()){
            ans += integers.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _1006_笨阶乘().clumsy(4));
    }
}
