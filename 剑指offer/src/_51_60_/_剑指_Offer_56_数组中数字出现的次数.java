package _51_60_;

import java.util.PriorityQueue;

public class _剑指_Offer_56_数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int div = nums[0];
        for (int i = 1;i < nums.length;i++){
            div ^= nums[i];
        }

        int c = 1;
        while ((c & div) == 0){
            c <<= 1;
        }
        int a = 0,b = 0;
        for (int num: nums){
            if ((c & num) == 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }

        return new int[]{a,b};
    }
}
