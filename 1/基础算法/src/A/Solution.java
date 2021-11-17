package A;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(nums[0],0);
        for (int i = 1;i < nums.length;i++){
            int j = target - nums[i];

            Integer integer = map.get(j);
            if (integer != null){
                return new int[]{integer,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().twoSum(new int[]{3, 2, 4}, 6));
    }
}