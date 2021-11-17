package _2020_2._21;

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;

        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxCount = 0;
        int l = 0;
        int r = 0;
        for (int i = s.length() - 1;i >= 0;i--){
            for (int j = i;j <= s.length() - 1;j++){
                if (j - i <= 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);

                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && maxCount < j - i + 1){
                    maxCount = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }
        String s1 = new String();
        for (int i = l; i <= r;i++){
            s1 = s1 + s.charAt(i);
        }
        return s1;
    }

}
