package _1__10;

public class _3_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return -1;

        for (int i = 0;i <= nums.length - 1;i++){
            while (nums[i] != i){
                if (nums[nums[i]] != nums[i]) {
                    swap(nums,nums[i],i);
                }else {
                    return nums[i];
                }
            }
        }
        return -1;
    }
    private void swap(int[] a,int i,int j){
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

}
