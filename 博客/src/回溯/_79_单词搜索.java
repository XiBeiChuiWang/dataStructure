package 回溯;

public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;

        boolean[][] booleans = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, chars, 0,booleans,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, char[] chars, int index, boolean[][] booleans, int row, int col) {
        if (chars[index] != board[row][col]){
            return false;
        }else if (index == chars.length - 1){
            return true;
        }

        boolean result = false;
        booleans[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions){
            int newrow = dir[0] + row;
            int newcol = dir[1] + col;

            if(newrow >= 0 && newrow < board.length && newcol >= 0 && newcol < board[0].length){
                if (!booleans[newrow][newcol]) {
                    boolean search = search(board,chars,index + 1,booleans,newrow,newcol);
                    if (search){
                        result = true;
                        break;
                    }
                }
            }
        }
        booleans[row][col] = false;
        return result;
    }
}
