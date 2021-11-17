package _1__10;

public class _剑指_Offer_10_斐波那契数列 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int f1 = 0;
        int f2 = 1;
        for (int i = 2;i <= n;i++){
            int f = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = f;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_10_斐波那契数列().fib1(46));
    }
}
