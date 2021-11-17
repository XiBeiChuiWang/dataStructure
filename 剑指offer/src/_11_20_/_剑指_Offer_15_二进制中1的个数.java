package _11_20_;

public class _剑指_Offer_15_二进制中1的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0){
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0){
            res++;
            n = (n - 1) & n;
        }
        return res;
    }
}
