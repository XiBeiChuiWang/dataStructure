package _21_30_;

public class _剑指_Offer_29_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        int[] ints = new int[matrix.length * matrix[0].length];
        int i = 0;
        int l = 0,r = matrix[0].length - 1,t = 0,s = matrix.length - 1;
        while (l <= r && t <= s){
            for (int col = l;col <= r;col++){
                ints[i++] = matrix[t][col];
            }
            t++;
            for (int row = t;row <= s;row++){
                ints[i++] = matrix[row][r];
            }
            r--;
            if (l <= r && t <= s){
                for (int col = r;col >= l;col--){
                    ints[i++] = matrix[s][col];
                }
                s--;
                for (int row = s;row >= t;row--){
                    ints[i++] = matrix[row][l];
                }
                l++;
            }
        }
        return ints;
    }
}
