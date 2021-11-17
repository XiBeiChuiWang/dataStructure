package 数组;

import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] max = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            int w = i - k + 1;

            if (w < 0) {
                continue;
            }

            if (deque.peekFirst() < w){
                deque.pollFirst();
            }

            max[w] = nums[deque.peekFirst()];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i: ints
             ) {
            System.out.println(i);
        }
    }
}