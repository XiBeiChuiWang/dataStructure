package 字节跳动._11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _19_56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];
        if (intervals.length == 1) return intervals;
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            //不重复
            if (i == 0 || l > ints.get(ints.size() - 1)[1]) {
                ints.add(new int[]{l, r});
            } else {
                ints.get(ints.size() - 1)[1] = Math.max(ints.get(ints.size() - 1)[1], r);
            }
        }
        int[][] ints1 = ints.toArray(new int[ints.size()][2]);
        return ints1;
    }
}
