package 字节跳动._11_20;

public class _14_121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] direction = new int[prices.length - 1];
        for (int i = 1;i < prices.length;i++){
            direction[i - 1] = prices[i] - prices[i - 1];
        }

        int[] dp = new int[direction.length];
        dp[0] = direction[0];
        int ans = Math.max(0,dp[0]);

        for (int i = 1;i < direction.length;i++){
            if (dp[i - 1] >= 0){
                dp[i] = dp[i - 1] + direction[i];
            }else {
                dp[i] = direction[i];
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
