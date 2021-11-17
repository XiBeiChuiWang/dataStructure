package 字节跳动._21_30;

public class _30_70_爬楼梯 {
    //暴力递归
    public int climbStairs(int n) {
        if (n < 3) return n;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    //动态规划
    public int climbStairs1(int n) {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
