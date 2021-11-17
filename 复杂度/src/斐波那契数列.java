public class 斐波那契数列 {
    //0 1 1 2 3 5 8
    //递归
    //O(2^n)
    public static long fei1(int n){
        if (n <= 1)
            return n;
        return fei1(n - 1)+fei1(n - 2);
    }
    //赋值
    //O(n)
    public static long fei2(int n){
        if (n <= 1)
            return n;
        long first = 0;
        long second = 1;
        long sum = 0;
        for (int i = 1;i <= n-1;i++){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        int i = 0;
        while (true){
            System.out.println(fei1(i)+"--"+i);
            i++;
            if (i>100)
                break;
        }
    }
}
