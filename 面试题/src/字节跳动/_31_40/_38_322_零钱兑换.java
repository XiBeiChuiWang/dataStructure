package 字节跳动._31_40;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class _38_322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1;i < dp.length;i++){
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
