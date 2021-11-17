import java.util.HashMap;

public class 最大上升子序列和 {
    int [] nums;

    public 最大上升子序列和(int[] nums) {
        this.nums = nums;
    }
    //错的
    //动态规划不能用  违反了无后效性
    public int 动态规划(){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        for (int i = 1;i < nums.length;i++){
            if (max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    //使用贪心+二分搜索
    //leetcode——300

    public int lengthOfLIS(){
        int[] len = new int[nums.length];
        len[1] = nums[0];
        int last = 1;
        for (int i = 1;i <nums.length;i++){
            if (nums[i] > len[last]){
                len[++last] = nums[i];
            }else {
                int l = 1, r = last, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (len[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                len[pos + 1] = nums[i];
            }
        }
        return last;
    }
}
