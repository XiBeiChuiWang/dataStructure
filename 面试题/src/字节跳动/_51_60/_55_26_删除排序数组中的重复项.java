package 字节跳动._51_60;

public class _55_26_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int i = 0;
        for (int j = 1;j < nums.length;j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
