package _11_20_;

public class _剑指_Offer_14_1_剪绳子 {
    public int cuttingRope(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2;i <= n;i++){
            int max = 0;
            for (int j = 1;j < i;j++){
                max = Math.max(max,Math.max((i - j) * j,dp[i - j] * j));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        if (n < 0) return -1;
        if (n < 4) return n - 1;
        int res = 1;
        while (n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
