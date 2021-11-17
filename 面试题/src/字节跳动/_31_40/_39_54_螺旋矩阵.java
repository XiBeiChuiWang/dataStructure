package 字节跳动._31_40;

import java.util.ArrayList;
import java.util.List;

public class _39_54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0 , bottom = matrix.length - 1;
        int left = 0 , right = matrix[0].length - 1;
        ArrayList<Integer> integers = new ArrayList<>();
        while (top <= bottom && left <= right){
            //left -> right
            for(int i = left;i <= right;i++){
                integers.add(matrix[top][i]);
            }
            top++;
            //top -> bottom
            for(int i = top;i <= bottom;i++){
                integers.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;
            //right -> left
            for(int i = right;i >= left;i--){
                integers.add(matrix[bottom][i]);
            }
            bottom--;
            //bottom -> top
            for(int i = bottom;i >= top;i--){
                integers.add(matrix[i][left]);
            }
            left++;
        }
        return integers;
    }
}
