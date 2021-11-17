package 动态规划;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i = 1;i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0;j < coins.length;j++){
                if (i < coins[j] || dp[i - coins[j]] < 0){
                    continue;
                }
                if (i >= coins[j] && dp[i - coins[j]] < min){
                    min = dp[i - coins[j]];
                }
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
