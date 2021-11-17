package 字节跳动._11_20;

public class _11_53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1;i <= nums.length - 1;i++){
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i - 1] + nums[i];
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
