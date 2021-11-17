package 栈;

import java.util.Stack;

public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> integers = new Stack<>();
        int[] next = new int[T.length];
        integers.push(0);
        for (int i = 1;i < T.length;i++){
            while (!integers.isEmpty() && T[i] > T[integers.peek()]){
                Integer pop = integers.pop();
                next[pop] = i - pop;
            }

            integers.push(i);
        }
        return next;
    }

    //倒推法  更优 类动态规划
    public static int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] values = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    values[i] = j - i;
                    break;
                } else if (values[j] == 0) {
                    values[i] = 0;
                    break;
                }

                j = j + values[j];
            }
        }
        return values;
    }

    public static void main(String[] args) {
        int[] ints = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures1(ints));
    }

}
