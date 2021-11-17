package 字节跳动._21_30;

public class _22_9_回文数 {
    //全反转
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x >= 0 && x <= 9) return true;

        int ans = 0;
        int num = x;
        while (num != 0){
            int mod = num % 10;
            ans = 10 * ans +mod;
            num = num / 10;
        }

        return ans == x;
    }

    //反转一半
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;

        int re = 0;

        while (x > re){
            re = re * 10 + x % 10;
            x = x / 10;
        }

        return x == re || x == re / 10;
    }
}
