package _1_10;

public class 剑指_Offer_12_矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        char[] chars = word.toCharArray();
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                    boolean dfs = dfs(board, chars, 0,i,j);
                    if (dfs) return true;

            }
        }
        return false;
    }

    public boolean dfs(char[][] board,char[] chars,int k,int row,int col){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != chars[k]) return false;

        if (k == chars.length - 1) return true;

        board[row][col] = '\0';

        boolean b = (dfs(board, chars, k + 1, row + 1, col) || dfs(board, chars, k + 1, row, col + 1) ||
                dfs(board, chars, k + 1, row - 1, col) || dfs(board, chars, k + 1, row, col - 1));

        board[row][col] = chars[k];
        return b;
    }

    public static void main(String[] args) {
        char[][] a = {{'a','b'},{'c','d'}};
        System.out.println(new 剑指_Offer_12_矩阵中的路径().exist(a, "abdc"));
    }
}
