public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return true;
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];


        for (int i = 0;i <= sLength;i++){
            for (int j = 0;j <= pLength;j++){
                if (j == 0){
                    dp[i][j] = i == 0;
                    continue;
                }

                if (j >= 2 && p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (i >= 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')){
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }else {
                    if (i >= 1 && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }
}
