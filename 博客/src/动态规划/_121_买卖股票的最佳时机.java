package 动态规划;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] p = new int[prices.length - 1];
        int[] dp = new int[prices.length - 1];
        for (int i = 0;i <= prices.length - 2;i++){
            p[i] = prices[i + 1] - prices[i];
        }

        int max = 0;
        dp[0] = p[0];
        for (int i = 1;i <= p.length - 1;i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + p[i];
            }else {
                dp[i] = p[i];
            }

            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
