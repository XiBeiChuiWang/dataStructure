package 字节跳动._41_50;

import java.util.Stack;

public class _46_32_最长有效括号 {
    public int 动态规划(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return 0;

        int[] dp = new int[s.length()];

        for (int i = 1;i < s.length();i++){

            if (s.charAt(i) == ')' && s.charAt(i - 1) == '('){
                if (i > 2){
                    dp[i] = dp[i - 2] + 2;
                }else {
                    dp[i] = 2;
                }
            }

            if (s.charAt(i) == ')' && s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                if (i - dp[i - 1] - 2 > 0){
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                }else {
                    dp[i] = dp[i - 1] + 2;
                }
            }
        }

        int max = dp[0];
        for (int i = 1;i < s.length();i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public int 栈(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return 0;

        Stack<Integer> integers = new Stack<>();
        integers.push(-1);
        int max = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                integers.push(i);
            }else {
                integers.pop();
                if (integers.isEmpty()){
                    integers.push(i);
                }else {
                    max = Math.max(max,i - integers.peek());
                }
            }
        }
        return max;
    }
}
