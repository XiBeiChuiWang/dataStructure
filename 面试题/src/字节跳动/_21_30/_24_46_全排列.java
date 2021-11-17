package 字节跳动._21_30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _24_46_全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i:nums
             ) {
            integers.add(i);
        }

        filling(nums.length,0,ans,integers);
        return ans;

    }


    //我们可以将题目给定的 nn 个数的数组 \textit{nums}[]nums[] 划分成左右两个部分，
    // 左边的表示已经填过的数，右边表示待填的数，我们在递归搜索的时候只要动态维护这个数组即可。
    private static void filling(int n,int first,List ans,List integer){
        if (first == n){
            ans.add(new ArrayList<Integer>(integer));
        }

        for (int i = first;i < n;i++){
            Collections.swap(integer,first,i);
            filling(n,first + 1,ans,integer);
            Collections.swap(integer,first,i);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
