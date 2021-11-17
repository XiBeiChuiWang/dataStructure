package 动态规划;

public class 最长回文子串 {
    public static int test(String s){
        if (s.length() <= 1)
            return s.length();

        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[chars.length][chars.length];

        int max = 0;

        for (int i = chars.length - 1;i >= 0;i--){
            for (int j = chars.length - 1;j >= i;j--){
                if (j - i <= 1){
                    dp[i][j] = chars[i] == chars[j];
                }else {
                    if (chars[i] == chars[j]){
                        dp[i][j] = dp[i + 1][j - 1];
                    }else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]){
                    max = Math.max(max,j - i + 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(test("babadab"));
    }
}
