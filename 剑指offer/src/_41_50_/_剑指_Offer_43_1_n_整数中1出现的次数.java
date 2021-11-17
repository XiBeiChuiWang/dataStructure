package _41_50_;

public class _剑指_Offer_43_1_n_整数中1出现的次数 {
    public int countDigitOne(int n) {
        int d = 1;
        int low = 0;
        int high = n / 10;
        int cur = n % 10;
        int res = 0;
        while (high != 0 || cur != 0){
            if (cur == 0){
                res += d * high;
            }else if (cur == 1){
                res += d * high + low + 1;
            }else {
                res += high * d + d;
            }
            low += cur * d;
            cur = high % 10;
            high = high / 10;
            d *= 10;
        }
        return res;
    }
}
