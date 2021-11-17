package 每日一题._3_;

import java.util.ArrayList;
import java.util.List;

public class _78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int mark = 1;mark < (1 << nums.length);mark++){
            ArrayList<Integer> integers = new ArrayList<>();

            for (int i = 0; i < nums.length; i++){
                if ((mark & (1 << i)) != 0){
                    integers.add(nums[i]);
                }
            }
            ans.add(integers);
        }
        return ans;
    }
}
