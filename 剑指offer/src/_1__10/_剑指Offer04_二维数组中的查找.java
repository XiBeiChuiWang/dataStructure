package _1__10;

public class _剑指Offer04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == target) return true;

            if (matrix[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
