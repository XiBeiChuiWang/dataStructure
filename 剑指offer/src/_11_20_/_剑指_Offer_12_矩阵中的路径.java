package _11_20_;

public class _剑指_Offer_12_矩阵中的路径 {
    int[][] ints = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;

        boolean[][] booleans = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                if (back(board,chars,0,booleans,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean back(char[][] board, char[] chars,int k,boolean[][] booleans,int row,int col){
        if (board[row][col] != chars[k]){
            return false;
        }else if (k == chars.length - 1){
            return true;
        }

        booleans[row][col] = true;
        boolean ans = false;
        for (int i = 0;i < ints.length;i++){
            int new_row = row + ints[i][0];
            int new_col = col + ints[i][1];
            if (new_row >= 0 && new_row < board.length && new_col >= 0 && new_col < board[0].length && !booleans[new_row][new_col]){
                boolean back = back(board, chars, k + 1, booleans, new_row, new_col);
                if (back){
                    ans = true;
                    break;
                }
            }
        }

        booleans[row][col] = false;
        return ans;
    }
}
