package 字节跳动._61_70;

public class _68_695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = i + di[index], next_j = j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }
}
