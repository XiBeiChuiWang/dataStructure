package _1_10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static int[][] multiplication(int[][] a,int[][] b){
        if (a == null || a.length == 0 || a[0].length == 0 || a.length != b[0].length)
            throw new RuntimeException("数组错误");

        int[][] ints = new int[a.length][b[0].length];

        for (int i = 0;i < ints.length;i++){
            for (int j = 0;j < ints[0].length;j++){
                int ans = 0;
                for (int x = 0;x < a[0].length;x++){
                    ans += a[i][x] * b[x][j];
                }
                ints[i][j] = ans;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[][] multiplication = Test.multiplication(new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {3, 4}});
        for (int[] i: multiplication
             ) {
            for (int i1: i
                 ) {
                System.out.println(i1);
            }
        }
    }
}
