package _21_30_;

public class _剑指_Offer_21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int[] ints = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] % 2 != 0){
                ints[l++] = nums[i];
            }else {
                ints[r--] = nums[i];
            }
        }
        return ints;
    }

    public int[] exchange1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (r > l){
            if (nums[l] % 2 == 0 && nums[r] % 2 == 1){
                int i = nums[l];
                nums[l] = nums[r];
                nums[r] = i;
                l++;
                r--;
            }else if (nums[l] % 2 == 0){
                r--;
            }else if (nums[r] % 2 == 1){
                l++;
            }else {
                l++;
                r--;
            }
        }
        return nums;
    }
}
