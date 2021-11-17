package 动态规划;

public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0;i <= word1.length();i++){
            dp[i][0] = i;
        }
        for (int j = 0;j <= word2.length();j++){
            dp[0][j] = j;
        }

        for (int i = 1;i <= word1.length();i++){
            for (int j = 1;j <= word2.length();j++){
                int add = dp[i - 1][j] + 1;
                int del = dp[i][j-1] + 1;
                int re = 0;
                if (chars1[i - 1] == chars2[j - 1]){
                    re = dp[i - 1][j - 1];
                }else {
                    re = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(Math.min(add,del),re);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
