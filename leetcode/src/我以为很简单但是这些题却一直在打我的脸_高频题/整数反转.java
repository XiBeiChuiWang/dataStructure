package 我以为很简单但是这些题却一直在打我的脸_高频题;

public class 整数反转 {
    public static int IntegerReverse(int i){
        int res = 0;
        while (i != 0){
            int prev = res;
            int mod = i % 10;
            res = res * 10 + mod;
            i /= 10;
            System.out.println();
            if (((res - mod) / 10) != prev){
                return 0;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(IntegerReverse(123));
    }
}
