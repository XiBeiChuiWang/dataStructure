package _41_50_;

public class _剑指_Offer_42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int ans = dp[0];

        for (int i = 1; i < nums.length;i++){
            if (dp[i - 1] <= 0){
                dp[i] = nums[i];
            }else {
                dp[i] = nums[i] + dp[i - 1];
            }
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
