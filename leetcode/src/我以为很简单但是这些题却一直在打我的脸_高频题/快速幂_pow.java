package 我以为很简单但是这些题却一直在打我的脸_高频题;

public class 快速幂_pow {
    public static double test(double d,int n){
        boolean b = n < 0 ;
        int y = b ? -n : n;
        double res = 1;
        while (y > 0){
            //   0111    y  每次右移一位 7--->0111    2^7 = 2^(0*2^3)*2^(1*2^2)*2^(1*2^1)*2^(1*2^0)
            //      1
            //-------------------
            //      1


            if ((y & 1) == 1){
                res *= d;
            }

            d *= d;

            y >>= 1;

        }
        return b ? (1 / res) : res;
    }

    public static void main(String[] args) {
        System.out.println(快速幂_pow.test(3,5));
    }
}
