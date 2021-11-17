package 字节跳动._51_60;

import java.util.ArrayDeque;
import java.util.Deque;

public class _52_85_最大矩形 {
    //动态规划1
    //时间复杂度 : O(N^2M)
    //空间复杂度 : O(NM)
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (matrix[i][j] == '0'){
                    continue;
                }else {
                    if (j != 0){
                        dp[i][j] = dp[i][j - 1] + 1;
                    }else {
                        dp[i][j] = 1;
                    }
                    int width = dp[i][j];
                    for (int x = i;x >= 0;x--){
                        width = Math.min(width,dp[x][j]);
                        ans = Math.max(ans,width * (i - x + 1));
                    }
                }
            }
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

}
