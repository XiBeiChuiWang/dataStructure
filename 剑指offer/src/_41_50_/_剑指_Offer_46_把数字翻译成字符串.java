package _41_50_;

public class _剑指_Offer_46_把数字翻译成字符串 {
    public int translateNum(int num) {
        if (num < 10) return 1;

        String s = String.valueOf(num);

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2;i < dp.length;i++){
            if (s.charAt(i - 1) == '0'){
                dp[i] = dp[i - 2];
            }else {
                int sum = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                if (sum >= 10 && sum < 26){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else if (sum < 10){
                    dp[i] = dp[i - 1];
                }else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_46_把数字翻译成字符串().translateNum(25));
    }
}
