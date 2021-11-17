package 动态规划;

public class 编辑距离_72 {
    public static int test(String a,String b){
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        //dp[i][j] 表示a[0,i) 变到b[0,j) 所需的最小步骤数
        int[][] dp = new int[charsa.length+1][charsb.length+1];

        for (int i = 1;i < charsb.length + 1;i++){
            dp[i][0] = i;
        }

        for (int i = 1;i < charsb.length + 1;i++){
            dp[0][i] = i;
        }

        for (int i = 1;i < charsa.length + 1;i++){
            for (int j = 1;j < charsb.length + 1;j++){
                int chanceNum = 0;
                if (charsa[i-1] == charsb[j - 1]){
                    chanceNum = dp[i - 1][j - 1];
                }else {
                    chanceNum = dp[i - 1][j - 1] + 1;
                }

                int deleteNum = dp[i - 1][j] + 1;
                int addNum = dp[i][j - 1] + 1;
                dp[i][j] = Math.min(Math.min(deleteNum,addNum),chanceNum);
            }
        }
        return dp[charsa.length][charsb.length];
    }

    public static void main(String[] args) {
        System.out.println(编辑距离_72.test("horse","ros"));
    }
}
