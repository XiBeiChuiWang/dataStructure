public class walk {
    int [][] dp;

    public walk(int count) {
        dp = new int[count][count];
    }

    public int walkcount(int a, int b){
        for (int i = 0;i < dp.length;i++){
            for (int j = 0;j < dp.length;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp [a][b];
    }
}
