package 回溯;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(list,nums,lists);
        return lists;
    }
    private void backtrack(List<Integer> list,int[] nums,List<List<Integer>> lists){

        if (list.size() == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0;i < nums.length;i++){
            if (list.contains(nums[i])){
                continue;
            }

            list.add(nums[i]);
            backtrack(list, nums, lists);
            list.remove((Integer) nums[i]);
        }
    }
}
