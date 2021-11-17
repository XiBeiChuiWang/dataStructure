package 精选;

import java.util.HashMap;

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(nums[0],0);
        for (int i = 1;i < nums.length;i++){
            Integer integer = integerIntegerHashMap.get(target - nums[i]);
            if (integer == null){
                integerIntegerHashMap.put(nums[i],i);
            }else {
                return new int[]{integer,i};
            }
        }
        return null;
    }
}
