package 字节跳动._41_50;

public class _49_122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int[] ints = new int[prices.length - 1];
        for (int i = 1;i < prices.length;i++){
            ints[i - 1] = prices[i] - prices[i - 1];
        }
        int ans = 0;
        for (int i = 0;i < ints.length;i++){
            if (ints[i] > 0){
                ans += ints[i];
            }
        }
        return ans;
    }
}
