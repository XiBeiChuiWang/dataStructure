package 字节跳动._21_30;

public class _27_72_编辑距离 {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 1;i < dp.length;i++){
            dp[i][0] = i;
        }
        for (int j = 1;j < dp[0].length;j++){
            dp[0][j] = j;
        }
        for (int i = 1;i < dp.length;i++){
            for (int j = 1;j < dp[0].length;j++){
                int add = dp[i][j - 1] + 1;
                int mov = dp[i - 1][j] + 1;
                int replace = 0;
                if (chars1[i - 1] == chars2[j - 1]){
                    replace = dp[i - 1][j - 1];
                }else {
                    replace = dp[i - 1][j - 1] + 1;
                }

                dp[i][j] = Math.min(Math.min(add,mov),replace);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
