package 字节跳动._61_70;

public class _63_198_打家劫舍 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        int ans = Math.max(dp[0],dp[1]);
        int max = 0;

        for (int i = 2;i < nums.length;i++){
            max = Math.max(dp[i - 2],max);
            dp[i] = max + nums[i];

            ans = Math.max(ans,max + nums[i]);
        }
        return ans;
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);



        int ans = Math.max(nums[0],nums[1]);
        int max = 0;
        int prevP = nums[0];
        int prev = nums[1];

        for (int i = 2;i < nums.length;i++){
            max = Math.max(prevP,max);
            int temp = prev;
            prev = nums[i] + max;
            prevP = temp;
            ans = Math.max(ans,max + nums[i]);
        }
        return ans;
    }
}
