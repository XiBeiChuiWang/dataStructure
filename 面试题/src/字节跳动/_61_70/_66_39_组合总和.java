package 字节跳动._61_70;

import java.util.ArrayList;
import java.util.List;

public class _66_39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> lists = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        huiSu(candidates,target,lists,ans,0);
        return ans;
    }

    private void huiSu(int[] candidates,int a,ArrayList list,ArrayList ans,int begin){
        if (a < 0) return;
        if (a == 0){
            ans.add(new ArrayList<Integer>(list));
        }

        for (int i = begin;i < candidates.length;i++){
            list.add(candidates[i]);
            huiSu(candidates, a - candidates[i], list, ans,i);
            list.remove(list.size() - 1);
        }
    }
}
