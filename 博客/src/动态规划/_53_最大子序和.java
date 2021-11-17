package 动态规划;

public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] ints = new int[nums.length];
        int max = nums[0];
        ints[0] = nums[0];
        for (int i = 1;i <= nums.length - 1;i++){
            if (ints[i - 1] > 0){
                ints[i] = ints[i - 1] + nums[i];
            }else {
                ints[i] = nums[i];
            }

            max = Math.max(max,ints[i]);
        }

        return max;
    }
}
