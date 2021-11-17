package _2020_2._22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0;first < nums.length;first++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1;second < nums.length;second++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if (second == third){
                    break;
                }

                if (nums[second] + nums[third] == target){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[first]);
                    integers.add(nums[second]);
                    integers.add(nums[third]);
                    lists.add(integers);
                }
            }
        }
        return lists;
    }
}
