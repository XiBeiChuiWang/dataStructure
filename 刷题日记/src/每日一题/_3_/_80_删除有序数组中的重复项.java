package 每日一题._3_;

public class _80_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int slow = 2;


        for (int fast = 2;fast < nums.length;fast++){
            if (nums[fast] == nums[fast - 2]){
                continue;
            }else {
                nums[slow++] = nums[fast];
            }
        }
        return slow + 1;
    }
}
