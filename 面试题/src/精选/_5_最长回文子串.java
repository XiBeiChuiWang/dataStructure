package 精选;

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.length() == 1) return s;
        char[] chars = s.toCharArray();
        Boolean dp[][] = new Boolean[s.length()][s.length()];
        int maxLength = 0;
        int l = 0;
        int r = 0;
        for (int i = s.length() - 1;i >= 0;i--){
            for(int j = s.length() - 1;j >= i;j--){

                if (j - i < 2){
                    dp[i][j] = chars[i] == chars[j];
                }else if (chars[i] == chars[j]){
                    dp[i][j] = dp[i + 1][j - 1];
                }else {
                    dp[i][j] = false;
                }


                if (dp[i][j] && maxLength < j-i+1){
                    maxLength = j-i+1;
                    l = i;
                    r = j;
                }
            }
        }
        String s1 = new String();
        for (int i = l; i <= r;i++){
            s1 = s1 + chars[i];
        }

        return s1;
    }
}
