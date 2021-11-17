package _11_20_;

public class _剑指_Offer_13_机器人的运动范围 {
    int ans = 0;
    int[][] ints = new int[][]{{0,1},{1,0}};
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0){
            return -1;
        }

        boolean[][] booleans = new boolean[m][n];
        back(booleans,0,0,k);
        return ans;
    }

    private void back(boolean[][] booleans,int row,int col,int k){
        if (!isCome(row, col, k)){
            return;
        }

        booleans[row][col] = true;
        ans++;
        for (int i = 0;i < ints.length;i++){
            int new_row = row + ints[i][0];
            int new_col = col + ints[i][1];

            if (new_row >= 0 && new_row < booleans.length && new_col >= 0 && new_col < booleans[0].length && !booleans[new_row][new_col]){
                back(booleans,new_row,new_col,k);
            }
        }
    }

    private boolean isCome(int row,int col,int k){
        int r = 0;
        while (row / 10 != 0){
            r += row % 10;
            row = row / 10;
        }
        r += row;
        int c = 0;
        while (col / 10 != 0){
            c += col % 10;
            col = col / 10;
        }
        c += col;
        return (r + c) <= k;
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_13_机器人的运动范围().movingCount(7, 2, 3));
    }
}
