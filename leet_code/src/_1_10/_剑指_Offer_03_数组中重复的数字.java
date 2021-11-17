package _1_10;

public class _剑指_Offer_03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0;i < nums.length;i++){
            while (nums [i] != i){
                if (nums[i] == nums[nums[i]])
                    return nums[i];

                int j = nums[i];
                nums[i] = nums[j];
                nums[j] = j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new _剑指_Offer_03_数组中重复的数字().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }
}
