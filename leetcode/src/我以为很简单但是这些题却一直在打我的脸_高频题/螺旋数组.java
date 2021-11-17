package 我以为很简单但是这些题却一直在打我的脸_高频题;

import java.util.ArrayList;

public class 螺旋数组 {
    public static void test(int[][] a){
        int top = 0 , bottom = a.length - 1;
        int left = 0 , right = a[0].length - 1;
        ArrayList<Integer> integers = new ArrayList<>();
        while (top <= bottom && left <= right){
            //left -> right
            for(int i = left;i <= right;i++){
                integers.add(a[top][i]);
            }
            top++;
            //top -> bottom
            for(int i = top;i <= bottom;i++){
                integers.add(a[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;
            //right -> left
            for(int i = right;i >= left;i--){
                integers.add(a[bottom][i]);
            }
            bottom--;
            //bottom -> top
            for(int i = bottom;i >= top;i--){
                integers.add(a[i][left]);
            }
            left++;
        }
        System.out.println(integers);
    }

    public static void main(String[] args) {
        test(new int[][]{{1,2,3,4},
                         {5,6,7,8},
                         {9,10,11,12}});
//        test(new int[][]{{1,2,5},
//                        {3,4,6},
//                        {7,8,9}});
    }
}
