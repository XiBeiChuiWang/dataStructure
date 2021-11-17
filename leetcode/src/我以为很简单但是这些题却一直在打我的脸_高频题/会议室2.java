package 我以为很简单但是这些题却一直在打我的脸_高频题;

import 我以为很简单但是这些题却一直在打我的脸_高频题.BinaryHeep.BinaryHeap;

import java.util.Arrays;
import java.util.Comparator;

public class 会议室2 {
    public static int 最小堆(int[][] a){
        //将a 按照会议开始时间进行排序
        Arrays.sort(a, (m1, m2) -> m1[0] - m2[0]);

        //建小顶堆
        BinaryHeap<Integer> integerBinaryHeap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //将第一个会议加入堆
        integerBinaryHeap.add(a[0][1]);
        for (int i = 1;i < a.length;i++){
            if (a[i][0] >= integerBinaryHeap.peek()){
                integerBinaryHeap.remove();
            }

            integerBinaryHeap.add(a[i][1]);
        }
        return integerBinaryHeap.size();
    }

    public static int 贪心(int[][] intervals){
        if (intervals == null || intervals.length == 0) return 0;
        // 存放所有会议的开始时间
        int[] begins = new int[intervals.length];
        // 存放所有会议的结束时间
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 排序
        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0, endIdx = 0;
        for (int begin : begins) {
            if (begin >= ends[endIdx]) { // 能重复利用会议室
                endIdx++;
            } else { // 需要新开一个会议室
                room++;
            }
        }

        return room;
    }

    public static void main(String[] args) {
        System.out.println(最小堆(new int[][]{
                {0,6},
                {4,14},
                {8,24},
                {16,22},
                {20,26}
        }));
    }
}
