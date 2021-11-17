package 每日一题._3_;

import java.util.concurrent.atomic.AtomicInteger;

public class _73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length; int n = matrix[0].length;
        boolean row = false; boolean col = false;
        for (int i = 0;i < m;i++){
            if (matrix[i][0] == 0){
                col = true;
                break;
            }
        }

        for (int i = 0;i < n;i++){
            if (matrix[0][i] == 0){
                row = true;
                break;
            }
        }

        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (row){
            for (int i = 0;i < n;i++){
                matrix[0][i] = 0;
            }
        }

        if (col){
            for (int i = 0;i < n;i++){
                matrix[i][0] = 0;
            }
        }


    }
}
