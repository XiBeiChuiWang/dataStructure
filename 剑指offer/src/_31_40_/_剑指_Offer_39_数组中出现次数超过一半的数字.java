package _31_40_;

public class _剑指_Offer_39_数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int index = nums[0];
        int count = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] == index){
                count++;
            }else {
                count--;
                if (count == 0){
                    index = nums[i];
                    count = 1;
                }
            }
        }
        return index;
    }
}
