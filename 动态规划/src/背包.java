public class 背包 {
    private int[] weight;
    private int[] value;

    public 背包(int[] weight, int[] value) {
        this.weight = weight;
        this.value = value;
        if (weight.length != value.length){
            throw new RuntimeException("输入错误");
        }
    }

    public int 动态规划(int w){
        int dp[][] = new int[weight.length+1][w+1];
        for (int i = 1;i <= weight.length;i++){
            for (int j = 1;j <= w;j++){
                if (weight[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],value[i - 1] + dp[i - 1][j - weight[i -1]]);
                }
            }
        }
        return dp[weight.length][w];
    }

}
