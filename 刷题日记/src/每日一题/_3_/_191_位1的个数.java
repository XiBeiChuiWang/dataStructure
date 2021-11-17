package 每日一题._3_;

public class _191_位1的个数 {
    public int hammingWeight(int n) {
        int count  = 0;
        while (n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
