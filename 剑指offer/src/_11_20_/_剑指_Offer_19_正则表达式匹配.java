package _11_20_;

public class _剑指_Offer_19_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0;i <= m;i++){
            for (int j = 0;j <= n;j++){
                //当p为空时
                if (j == 0){
                    dp[i][j] = i == 0;
                    continue;
                }
                //p不为空时，我们分两种情况
                //当结尾是*
                if (j >= 2 && p.charAt(j - 1) == '*'){
                    //选择匹配0次
                    dp[i][j] = dp[i][j - 2];
                    //选择匹配0次或多次（前提是p.charAt(j - 2) == s.charAt(i - 1)）
                    if (i >= 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')){
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                 //当结尾不为*
                }else {
                    //如果结尾相同
                    if (i >= 1 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    //如果不同则直接为false
                }
            }
        }
        return dp[m][n];
    }
}
