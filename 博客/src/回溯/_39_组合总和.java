package 回溯;

import java.util.ArrayList;
import java.util.List;

public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        combination(list,lists,candidates,target,0);
        return lists;
    }

    private void combination(ArrayList<Integer> list,ArrayList<List<Integer>> lists,int[] candidates,int sum,int begin){
        if (sum == 0){
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = begin;i < candidates.length;i++){
            if (sum < candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            combination(list, lists, candidates, sum - candidates[i],i);
            list.remove((Integer) candidates[i]);
        }
    }
}
