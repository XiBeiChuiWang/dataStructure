package _51_60_;

import java.util.ArrayList;

public class _剑指_Offer_57_和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        if (target <= 0) return new int[][]{};
        if (target == 1) return new int[][]{{1}};

        ArrayList<int[]> ints = new ArrayList<>();
        for (int l = 1,r = 2;r <= target / 2 + 1&& l < r;){
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target){
                int[] ints1 = new int[r - l + 1];
                for (int i = l;i <= r;i++){
                    ints1[i - l] = i;
                }
                ints.add(ints1);
                l++;
            }else if (sum > target){
                l++;
            }else {
                r++;
            }
        }
        return  ints.toArray(new int[ints.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_57_和为s的连续正数序列().findContinuousSequence(9));
    }
}
