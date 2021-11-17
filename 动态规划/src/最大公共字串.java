public class 最大公共字串 {
    String a;
    String b;
    char[] s1;
    char[] s2;
    public 最大公共字串(String a, String b) {
        this.a = a;
        this.b = b;
        s1 = a.toCharArray();
        s2 = b.toCharArray();
    }

    public int 动态规划(){
        int dp[][] = new int[s1.length+1][s2.length+1];
        for (int i = 0;i <= s1.length;i++){
            for (int j = 0;j <= s2.length;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if (s1[i - 1] == s2[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 1;i <= s1.length;i++){
            for (int j = 1;j <= s2.length;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
