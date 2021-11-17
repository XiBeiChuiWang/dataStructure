package 每日一题._3_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_子集_2 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int mark = 1;mark < (1 << nums.length);mark++){
            ArrayList<Integer> integers = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < nums.length; i++){
                if ((mark & (1 << i)) != 0){

                    if (i > 0 && nums[i] == nums[i - 1] && ((1 << (i - 1)) & mark) == 0){
                        flag = false;
                        continue;
                    }

                    integers.add(nums[i]);
                }
            }
            if (flag){
                ans.add(integers);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _90_子集_2().subsets(new int[]{1, 2, 2}));
    }
}
