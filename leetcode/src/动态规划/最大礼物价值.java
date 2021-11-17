package 动态规划;

public class 最大礼物价值 {
    public static int 动态规划(int[][] values){
        int[][] dp = new int[values.length][values[0].length];
        dp[0][0] = values[0][0];
        for (int i = 1;i < values.length;i++){
            dp[i][0] = values[i][0]+dp[i-1][0];
        }
        for (int i = 1;i < values[0].length;i++){
            dp[0][i] = values[0][i] + dp[0][i-1];
        }

        for (int i = 1;i < values.length;i++){
            for (int j = 1;j < values[0].length;j++){
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + values[i][j];
            }
        }
        return dp[values.length-1][values[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(最大礼物价值.动态规划(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
