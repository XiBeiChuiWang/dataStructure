package 我以为很简单但是这些题却一直在打我的脸_高频题;

public class 约瑟夫环 {
    public static int 递归(int n,int m){
        if (n == 1) return 0;
        return (递归(n - 1,m) + m) % n;
    }

    public static int 非递归(int n,int m){
        int res = 0;
        for (int i = 2;i <= n;i++){
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(非递归(5,2));
    }
}
