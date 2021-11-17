package 字节跳动._41_50;

public class _48_79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        boolean[][] b = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                if (dfs(board,b,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] booleans, int i, int j, String word, int k){
        if (word.charAt(k) != board[i][j]){
            return false;
        }else if (k == word.length() - 1){
            return true;
        }
        boolean result = false;
        booleans[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions){
            int newi = dir[0] + i;
            int newj = dir[1] + j;

            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if (!booleans[newi][newj]) {
                    boolean dfs = dfs(board, booleans, newi, newj, word, k + 1);
                    if (dfs){
                        result = true;
                        break;
                    }
                }
            }
        }
        booleans[i][j] = false;
        return result;
    }
}
