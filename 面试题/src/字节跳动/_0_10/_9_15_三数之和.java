package 字节跳动._0_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9_15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> arrayLists = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return arrayLists;
        Arrays.sort(nums);
        int last = nums.length - 1;
        for (int i = 0;i <= nums.length - 3;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = last;
            int remain = -nums[i];
            while (l < r){
                if (remain == nums[l] + nums[r]){
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    arrayLists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else if (remain > nums[l] + nums[r]){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
