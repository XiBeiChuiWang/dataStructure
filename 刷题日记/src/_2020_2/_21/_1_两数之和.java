package _2020_2._21;

import java.util.HashMap;

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();

        integerIntegerHashMap.put(nums[0],0);

        for (int i = 1;i < nums.length;i++){
            int n = target - nums[i];
            Integer integer = integerIntegerHashMap.get(n);
            if (integer == null){
                integerIntegerHashMap.put(nums[i],i);
                continue;
            }else {
                return new int[]{integer,i};
            }
        }
        return null;
    }
}
