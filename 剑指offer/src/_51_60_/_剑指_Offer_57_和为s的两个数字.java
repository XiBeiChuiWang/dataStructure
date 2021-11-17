package _51_60_;

public class _剑指_Offer_57_和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) return new int[]{};
        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            if (nums[l] + nums[r] == target) return new int[]{nums[l],nums[r]};
            if (nums[l] + nums[r] > target){
                r--;
            }else {
                l++;
            }
        }
        return new int[]{};
    }
}
