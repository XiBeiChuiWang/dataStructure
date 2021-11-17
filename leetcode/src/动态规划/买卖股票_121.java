package 动态规划;

public class 买卖股票_121 {
    public static int test(int[] a){
        int[] ints = new int[a.length - 1];

        for (int i = 1;i < a.length;i++){
            ints[i - 1] = a[i] - a[i - 1];
        }
        //此时问题变为最长公共子序列问题
        int dp[] = new int[a.length - 1];
        dp[0] = ints[0];
        int max = 0;
        for (int i = 1;i < dp.length;i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + ints[i];
            }else {
                dp[i] = ints[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(买卖股票_121.test(new int[]{7,1,5,3,6,4,100}));
    }
}
