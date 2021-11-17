package _31_40_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _剑指_Offer_40_最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[]{};
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        integers.add(arr[0]);

        for (int i = 1;i < arr.length;i++){

            if (integers.size() < k){
                integers.offer(arr[i]);
                continue;
            }
            if (integers.peek() > arr[i]){
                integers.poll();
                integers.offer(arr[i]);
            }
        }
        int[] ints = new int[k];
        for (int i = k - 1;i >= 0;i--){
            ints[i] = integers.poll();
        }
//        ArrayList<Integer> integers1 = new ArrayList<>(integers);
        return ints;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k == 0) return new ArrayList();
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        integers.add(input[0]);

        for (int i = 1;i < input.length;i++){

            if (integers.size() < k){
                integers.offer(input[i]);
                continue;
            }
            if (integers.peek() > input[i]){
                integers.poll();
                integers.offer(input[i]);
            }
        }
        ArrayList<Integer> integers1 = new ArrayList<>(integers);
        return integers1;
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_40_最小的k个数().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }
}
